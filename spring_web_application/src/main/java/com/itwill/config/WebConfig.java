package com.itwill.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//controller에서 개별 설정 가능한데 전역에 설정해주기 위해서 쓴다.
@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index.jsp");
		
	}
}
