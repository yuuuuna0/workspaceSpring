package com.itwill.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
public class Controller파라메타타입 {
	/*
	﻿public String hello(
			HttpServletRequest request
          , HttpServletResponse response
          , HttpSession session
          , WebRequest webRequest                  
          ,NaviteWebRequest nwRequest                  
          , Locale locale    	//국제화 작업 가능하게 함              
          , InputStream is                  
          , Reader reader                  
          , OutputStream os                  
          , Writer writer                  
          , @PathVariable("name") String name                  
          , @RequestParam("name") String name    // 이 name 파라미터가 없으면 400 오류 발생                  
          , @RequestParam(value="name", required=false, defaultValue="디폴트") String name // name 파라미터를 안받을 경우 기본값 설정                  
          , @RequestParam String name // 메서드 파라미터의 이름과 요청파라미터가 같다면 ("name") 생략가능                  
          , String name // 메서드 파라미터의 이름과 요청파라미터가 같고 String, int등 단순한 타입의 경우 @RequestParam 생략가능                  
          , @RequestParam Map<String, String> params // 모든요청파라미터를 Map으로 담는다.                  
          , @CookieValue("cookieName") String cookieName // 값없으면 404 오류 발생                  
          , @CookieValue(value="cookieName", required=false, defaultValue="test") String cookieName                  
          , @RequestHeader("Host") String host   // 값없으면 404 오류 발생                  
          , @RequestHeader("Keep-Alive") long keepAlive  // 값없으면 404 오류 발생                  
          , ModelMap model                  
          , Model model                  
          , Map map                  
          , @ModelAttribute UserModel userModel                  
          , @ModelAttribute("xxUser") UserModel userModel                  
          , @ModelAttribute UserModel userModel, BindingResult bindingResult                  
          , @ModelAttribute UserModel userModel, Errors errors                  
          , SessionStatus sessionStatus                  
          , @RequestBody String body                  
          , @Value("#{commonprop['os.name']}") String osName                   
          , @Valid){...}     
			//@PathVariable는 @RequestMapping와 함께 사용된다. 
          */
			
}
