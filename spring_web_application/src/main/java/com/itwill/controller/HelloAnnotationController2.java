package com.itwill.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloAnnotationController2 {
	public HelloAnnotationController2() {
		System.out.println("### HelloAnnotationController2() 생성자 호출");
	}
	@RequestMapping("/hello2")
	public String hello2(HttpServletRequest request) {
		System.out.println("### HelloAnnotationController2.hello2()메소드 호출");
		request.setAttribute("msg", "HelloAnnotationController2 안녕");
		return "forward:/WEB-INF/views/hello2.jsp";
	}
}
