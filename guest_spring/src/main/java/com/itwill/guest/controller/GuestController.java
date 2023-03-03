package com.itwill.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itwill.guest.Guest;
import com.itwill.guest.GuestService;
@Controller
public class GuestController {
	@Autowired
	private GuestService guestService; 
	public GuestController() {
		System.out.println(">>>GuestController");
	}
	
	@RequestMapping("/")
	public String guest() {	
		String forwardPath = "redirect:guest_main";
		return forwardPath;
	}
	@RequestMapping("/guest_main")
	public String guest_main() {	
		String forwardPath = "guest_main";
		return forwardPath;
	}
	@RequestMapping("/guest_list")
	public String guest_list(HttpServletRequest request /*Model model 사용해도 됨*/) throws Exception{
		String forwardPath="";
		List<Guest> guestList=guestService.selectAll();
		request.setAttribute("guestList", guestList);
		forwardPath = "guest_list";
		return forwardPath;
	}
	
	//parameter에 guest_no가 존재할 때
	@RequestMapping(value="/guest_view", params = "guest_no")
	public String guest_view(@RequestParam Integer guest_no, Model model ) throws Exception{
		Guest guest=guestService.selectByNo(guest_no);
		model.addAttribute("guest",guest);
		String forwardPath = "guest_view";
		return forwardPath;
	}
	//parameter에 guest_no가 존재하지 않을 때
	@RequestMapping(value="/guest_view", params = "!guest_no")
	public String guest_view() throws Exception{
		String forwardPath = "redirect:guest_main";
		return forwardPath;
	}
	
	//parameter에 guest_no가 존재할 때
	@PostMapping(value="/guest_modify_form",params="guest_no")
	public String guest_modify_form(@RequestParam Integer guest_no,Model model) throws Exception{
		Guest guest=guestService.selectByNo(guest_no);
		model.addAttribute("guest", guest);
		String forwardPath = "guest_modify_form";
		return forwardPath;
	}
	//parameter에 guest_no가 존재하지 않을 때
	@PostMapping(value="/guest_modify_form",params="!guest_no")
	public String guest_modify_form() throws Exception{
		String forwardPath = "redirect:guest_main";
		return forwardPath;
	}
	
	@RequestMapping("/guest_write_form")
	public String guest_write_form() {
		String forwardPath = "guest_write_form";
		return forwardPath;
	}
	@PostMapping("/guest_write_action")
	public String guest_write_action(@ModelAttribute Guest guest,RedirectAttributes redirectAttributes) throws Exception{
		int guest_no=guestService.insertGuest(guest);
		redirectAttributes.addAttribute("guest_no", guest_no);
		String forwardPath = "redirect:guest_view";
		return forwardPath;
	}
	@PostMapping("/guest_modify_action")
	public String guest_modify_action(@ModelAttribute Guest guest,Model model) throws Exception{
		int result=guestService.updateGuest(guest);
		model.addAttribute("guest", guest);
		String forwardPath = "redirect:guest_view";
		return forwardPath;
	}
	@PostMapping("/guest_remove_action")
	public String guest_remove_action(@RequestParam Integer guest_no) throws Exception{
		int result=guestService.deleteGuest(guest_no);
		String forwardPath = "redirect:guest_list";
		return forwardPath;
	}

	
	
	
	@GetMapping(value= {"/guest_write_action_get",
						"/guest_remove_action_get",
						"/guest_modify_form_get",
						"/guest_modify_action_get"})
	public String guest_get() {
		String forwardPath="redirect:guest_main";
		return forwardPath;
	}
/*
	@GetMapping("/guest_write_action_get")
	public String guest_write_action_get() {
		String forwardPath = "redirect:guest_main";
		return forwardPath;
	} 
 	@GetMapping("/guest_remove_action_get")
	public String guest_remove_action_get() {
		String forwardPath = "redirect:guest_remove_action";
		return forwardPath;
	}
 	@GetMapping("/guest_modify_form_get")
	public String guest_modify_form_get() {
		//###############안됨,,,,################
		String forwardPath = "redirect:guest_main";
		return forwardPath;
	}
 	@GetMapping("guest_modify_action_get")
	public String guest_modify_action_get() {
		String forwardPath = "redirect:guest_main";
		return forwardPath;
	}
 */

	@ExceptionHandler(Exception.class)
	public String guest_exception_handler(Exception e) {
		return "guest_error";
	}
/*
	@RequestMapping("/guest_error")
	public String guest_error() {
		String forwardPath = "guest_error";
		return forwardPath;
	}
 */
}
