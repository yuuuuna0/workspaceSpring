package com.itwill.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itwill.user.User;
import com.itwill.user.UserService;
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
	public String user_write_action_post(@ModelAttribute User user) throws Exception {
		String forwardPath="";
		int result=userService.create(user);
		if(result==1) {
			forwardPath = "redirect:/user_login_form";
		}else if(result==-1) {
			forwardPath="redirect:/user_write_form";
		}
		return forwardPath;
	}
	@RequestMapping("/user_login_form")
	public String user_login_form() {
		String forwardPath = "user_login_form";
		return forwardPath;
	}
	@PostMapping("/user_login_action")
	public String user_login_action_post(@ModelAttribute User user,Model model,HttpSession session) throws Exception {
		String forwardPath="";
		int result=userService.login(user.getUserId(), user.getPassword());
		if(result==0) {
			model.addAttribute("fuser", user);
			forwardPath="redirect:user_login_form";
		}else if(result==1) {
			model.addAttribute("fuser", user);
			forwardPath="redirect:user_login_form";
		}else if(result==2) {
			session.setAttribute("sUserId", user.getUserId());
			forwardPath="redirect:user_view";
		}
		return forwardPath;
	}
	
	
	
	
	
	
	
	
	
	
	public String user_view(HttpSession session) throws Exception {
		/************** login check **************/
		String forwardPath="";
		if(session.getAttribute("sUserId")!=null){
			forwardPath = "redirect:user_view?userId="+session.getAttribute("sUserId");
		} else {
			forwardPath="redirect:user_login_form";
		}
		return forwardPath;
	}

	@PostMapping("user_modify_form")
	public String user_modify_form_post() throws Exception {
		/************** login check **************/

		String forwardPath = "user_modify_form";

		return forwardPath;
	}
	@PostMapping("user_modify_action")
	public String user_modify_action_post() throws Exception {
		/************** login check **************/
		String forwardPath = "redirect:user_view";
		return forwardPath;
	}
	@PostMapping("user_remove_action")
	public String user_remove_action_post() throws Exception {
		/************** login check **************/
		String forwardPath = "redirect:user_main";
		return forwardPath;
	}

	
	
	
	
	
	
	
	
	
	public String user_logout_action(HttpSession session) {
		/************** login check **************/
		String forwardPath = "";
		return forwardPath;
	}

	public String user_action_get() {
		String forwardPath = "";
		return forwardPath;
	}


}
