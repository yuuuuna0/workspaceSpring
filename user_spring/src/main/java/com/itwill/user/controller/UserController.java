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
	public String user_view(HttpSession session) throws Exception {
		/************** login check **************/
		String forwardPath="";
		if(session.getAttribute("sUserId")==null){
			forwardPath="redirect:user_login_form";
			return forwardPath;
		}
			User loginUser=userService.findUser((String)session.getAttribute("sUserId"));
			session.setAttribute("loginUser", loginUser);
			forwardPath = "user_view";
		return forwardPath;
	}
	@PostMapping("/user_remove_action")
	public String user_remove_action_post(HttpSession session) throws Exception {
		/************** login check **************/
		String forwardPath="";
		if(session.getAttribute("sUserId")==null){
			forwardPath="redirect:user_login_form";
			return forwardPath;
		}
		int result=userService.remove((String)session.getAttribute("sUserId"));
		session.invalidate();
		forwardPath = "redirect:user_main";
		return forwardPath;
	}
	@RequestMapping("/user_logout_action")
	public String user_logout_action(HttpSession session) {
		/************** login check **************/
		String forwardPath="";
		if(session.getAttribute("sUserId")==null){
			forwardPath="redirect:user_login_form";
			return forwardPath;
		}
		session.invalidate();
		forwardPath="redirect:user_main";
		return forwardPath;
	}
	
	
	
	@PostMapping("/user_modify_form")
	public String user_modify_form_post(HttpSession session,Model model) throws Exception {
		/************** login check **************/
		String forwardPath="";
		if(session.getAttribute("sUserId")==null){
			forwardPath="redirect:user_login_form";
			return forwardPath;
		}
		User loginUser=userService.findUser((String)session.getAttribute("sUserId"));
		model.addAttribute("loginUser", loginUser);
		forwardPath = "user_modify_form";
		return forwardPath;
	}
	
	@PostMapping("/user_modify_action")
	public String user_modify_action_post(@ModelAttribute User user, HttpSession session) throws Exception {
		/************** login check **************/
		String forwardPath="";
		if(session.getAttribute("sUserId")==null){
			forwardPath="redirect:user_login_form";
			return forwardPath;
		}
		session.setAttribute("loginUser", user);
		forwardPath = "redirect:user_view";
		return forwardPath;
	}

	
	
	/***********GET방식요청시 guest_main redirection*********/
	@GetMapping({
				"/user_write_action",
				"/user_login_action",
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
