package com.itwill.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
	@GetMapping(value = "/list")
	public String list() {
		System.out.println("/list ==> UserController.list() 호출");
		return "";
	}
}
