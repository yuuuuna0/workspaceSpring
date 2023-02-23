package com.itwill.guest.dao.jdbctemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringBootJdbcTemplateMain {

	public static void main(String[] args) {
		ApplicationContext applicationContext=SpringApplication.run(SpringBootJdbcTemplateMain.class, args);
		JdbcTemplate jdbcTemplate=(JdbcTemplate)applicationContext.getBean(JdbcTemplate.class);
		System.out.println("1. JdbcTemplate : "+jdbcTemplate);
		
	}

}
