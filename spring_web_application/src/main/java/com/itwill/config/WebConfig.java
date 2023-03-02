package com.itwill.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//controller에서 개별 설정 가능한데 전역에 설정해주기 위해서 쓴다.
import org.springframework.web.servlet.view.BeanNameViewResolver;
@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/index.jsp");
	}
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		//registry.jsp("/WEB-INF/views/",".jsp");
	}
	
	/**************************** spring mvc 객체 등록 *****************************/
	@Bean
	public BeanNameViewResolver beanNameViewResolver() {
		BeanNameViewResolver beanNameViewResolver=new BeanNameViewResolver();
		beanNameViewResolver.setOrder(0);
		//order가 낮으면 우선순위가 높다
		return beanNameViewResolver;
	}



}
