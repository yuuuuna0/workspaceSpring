package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwill.user.User;
import com.itwill.user.UserService;
import com.itwill.user.exception.ExistedUserException;
import com.itwill.user.exception.PasswordMisMatchException;
import com.itwill.user.exception.UserNotFoundException;
/*
 * /user_main 
 * /user_write_form 
 * /user_write_action 
 * /user_login_form
 * /user_login_action 
 * /user_logout_action 
 * /user_view /user_modify_form
 * /user_modify_action 
 * /user_remove_action
 */
@Controller
public class UserController {
	@Autowired
	private UserService userService;
	//아래거 있고 없고 차이 (url에 session 보임) --> 설정에서 session tracing mode를 cookie로 설정
	@RequestMapping("/")
	public String user_common() {
		return "redirect:user_main";
	}
	@RequestMapping("/user_main")
	public String user_main() {
		return "user_main";
	}
	@RequestMapping("/user_write_form")
	public String user_write_form() {
		String forwardPath = "user_write_form";
		return forwardPath;
	}
	@PostMapping("/user_write_action")
	public String user_write_action(@ModelAttribute("fuser") User user,Model model) throws Exception {
		String forward_path = "";
		try {
			int rowCount = userService.create(user);
			forward_path="redirect:user_login_form";
		}catch (ExistedUserException e) {
			model.addAttribute("msg", e.getMessage());
			//model.addAttribute("fuser", user);
			forward_path="user_write_form";
		}
		return forward_path;
	}
	@RequestMapping("/user_login_form")
	public String user_login_form() {
		String forwardPath = "user_login_form";
		return forwardPath;
	}
	@PostMapping("/user_login_action")
	public String user_login_action_post(@ModelAttribute("fuser") User user,Model model,HttpSession session) throws Exception {
		String forwardPath="";
		try {
			userService.login(user.getUserId(), user.getPassword());
			session.setAttribute("sUserId", user.getUserId());
			forwardPath="redirect:user_main";
		} catch (UserNotFoundException e) {
			e.printStackTrace();
			model.addAttribute("msg1",e.getMessage());
			forwardPath="user_login_form";
		} catch (PasswordMisMatchException e) {
			e.printStackTrace();
			model.addAttribute("msg2",e.getMessage());
			forwardPath="user_login_form";
		}
		return forwardPath;
	}
	@RequestMapping("/user_view")
	//인자를 HttpSession 대신 HttpServletRequest 쓰는 이유 
	//		-->  session에는 login시 user를 담는 것이지 view를 볼 때 session에 담는게 아니기 때문 
	//			 & session 인자로 받으면 Model 객체도 받아서 넣어줘야 함.
	public String user_view(HttpServletRequest request) throws Exception {
		String forwardPath="";
		/************** login check **************/
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		if(sUserId==null){
			forwardPath="redirect:user_login_form";
			return forwardPath;
		}
		User loginUser=userService.findUser(sUserId);
		request.setAttribute("loginUser", loginUser);
		forwardPath = "user_view";
		return forwardPath;
	}
	@PostMapping("/user_modify_form")
	public String user_modify_form_post(HttpServletRequest request) throws Exception {
		String forwardPath="";
		/************** login check **************/
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		if(sUserId==null){
			forwardPath="redirect:user_login_form";
			return forwardPath;
		}
		User loginUser=userService.findUser(sUserId);
		request.setAttribute("loginUser", loginUser);
		forwardPath = "user_modify_form";
		return forwardPath;
	}
	@PostMapping("/user_modify_action")
	public String user_modify_action_post(@ModelAttribute User user, HttpServletRequest request) throws Exception {
		String forwardPath="";
		/************** login check **************/
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		if(sUserId==null){
			forwardPath="redirect:user_login_form";
			return forwardPath;
		}
		int result=userService.update(user);
		//업데이트 후 session에 있는 데이터를 쓰기 때문에 해당 메소드의 데이터를 넘기지 않아도 된다.
		forwardPath = "redirect:user_view";
		return forwardPath;
	}
	@PostMapping("/user_remove_action")
	public String user_remove_action_post(HttpServletRequest request) throws Exception {
		String forwardPath="";
		/************** login check **************/
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		if(sUserId==null){
			forwardPath="redirect:user_main";
			return forwardPath;
		}
		int result=userService.remove(sUserId);
		request.getSession().invalidate();
		/*
		forwardPath = "forward:user_logout_action";	//forward를 반드시 붙여야 한다. 
													//	--> controller에 맵핑되어있는 다른 url을 요청할 때 붙인다.
													//	--> controller맵핑을 먼저 찾고 그 다음 jsp를 찾음. (잘 쓰는 방법은 아니다. forwarding을 여러번 하는 건 좋은 방법이 아님)
		*/
		forwardPath ="redirect:user_main";
		return forwardPath;
	}
	@RequestMapping("/user_logout_action")
	public String user_logout_action(HttpServletRequest request) {
		String forwardPath="";
		/************** login check **************/
		String sUserId=(String)request.getSession().getAttribute("sUserId");
		if(sUserId==null){
			forwardPath="redirect:user_main";
			return forwardPath;
		}
		request.getSession().invalidate();
		//request.getSession(false).invalidate();	--> session이 존재하지 않으면 null을 반환한다?
		forwardPath="redirect:user_main";
		return forwardPath;
	}
	
	
	
	

	
	
	/***********GET방식요청시 guest_main redirection*********/
	@GetMapping({
				"/user_write_action",
				"/user_login_action",
				"/user_mofidy_form",
				"/user_modify_action",
				"/user_remove_action"
				})
	public String user_get() {
		String forwardPath = "redirect:user_main";
		return forwardPath;
	}
	
	/****************Local Exception Handler***********/
	@ExceptionHandler(Exception.class)
	public String user_exception_handler(Exception e) {
		return "user_error";
	}


}
