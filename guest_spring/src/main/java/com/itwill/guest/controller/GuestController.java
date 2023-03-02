package com.itwill.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		String forwardPath = "forward:/WEB-INF/views/guest_main.jsp";
		return forwardPath;
	}
	@RequestMapping("/guest_main")
	public String guest_main() {	
		String forwardPath = "forward:/WEB-INF/views/guest_main.jsp";
		return forwardPath;
	}
	@RequestMapping("/guest_list")
	public String guest_list(HttpServletRequest request) throws Exception{
		List<Guest> guestList=guestService.selectAll();
		request.setAttribute("guestList", guestList);
		String forwardPath = "forward:/WEB-INF/views/guest_list.jsp";
		return forwardPath;
	}
	@RequestMapping("/guest_error")
	public String guest_error() {
		String forwardPath = "forward:/WEB-INF/views/guest_error.jsp";
		return forwardPath;
	}
	@PostMapping("/guest_modify_action")
	public String guest_modify_action(@ModelAttribute Guest guest,Model model) throws Exception{
		int result=guestService.updateGuest(guest);
		model.addAttribute("guest", guest);
		String forwardPath = "redirect:guest_view?guest_no="+guest.guest_no;
		return forwardPath;
	}
	@PostMapping("/guest_modify_form")
	public String guest_modify_form(@RequestParam Integer guest_no,Model model) throws Exception{
		Guest guest=guestService.selectByNo(guest_no);
		model.addAttribute("guest", guest);
		String forwardPath = "forward:/WEB-INF/views/guest_modify_form.jsp";
		return forwardPath;
	}
	@PostMapping("/guest_remove_action")
	public String guest_remove_action(@RequestParam Integer guest_no) throws Exception{
		int result=guestService.deleteGuest(guest_no);
		String forwardPath = "redirect:guest_list";
		return forwardPath;
	}
	@GetMapping("/guest_view")
	public String guest_view(@RequestParam Integer guest_no, Model model ) throws Exception{
		Guest guest=guestService.selectByNo(guest_no);
		model.addAttribute("guest",guest);
		String forwardPath = "forward:/WEB-INF/views/guest_view.jsp";
		return forwardPath;
	}
	@PostMapping("/guest_write_action")
	public String guest_write_action(@ModelAttribute Guest guest) throws Exception{
		int result=guestService.insertGuest(guest);
		String forwardPath = "redirect:/guest_list";
		return forwardPath;
	}
	@RequestMapping("/guest_write_form")
	public String guest_write_form() {
		String forwardPath = "forward:/WEB-INF/views/guest_write_form.jsp";
		return forwardPath;
	}
	
	@GetMapping(value= {"/guest_write_action_get","/guest_remove_action_get","/guest_modify_form_get","/guest_modify_action_get"})
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

}
