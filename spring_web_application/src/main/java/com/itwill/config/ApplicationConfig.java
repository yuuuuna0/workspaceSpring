package com.itwill.config;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
//application의 config 설정
public class ApplicationConfig {
	/****************** MessageSource 등록 *******************/
	@Bean("messageSource")
	public MessageSource messageSource() {
		ResourceBundleMessageSource resourceBundleMessageSource=new ResourceBundleMessageSource(); 
		resourceBundleMessageSource.setBasenames("messages/messages","messages/user");
		return resourceBundleMessageSource;
	}

}
