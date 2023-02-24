package com.itwill0.context;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.itwill.product.ProductService;

public class SpringApplicationMain {
	public static void main(String[] args) {
		/*
		 * 	Spring Container 객체 생성
		 * 		- ApplicationContext[BeanFactory] 객체 생성
		 */
		
		/*
		 * 1. Spring Bean 설정파일을 읽어서 SpringContainer 객체 생성
		 */
		System.out.println("----------- Application 생성 시작 ------------");
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("com/itwill0/context/0.application_context.xml");	//JavaApplicationMain에서 호출 전단계의 작업을 다 해주게 됨
		System.out.println("----------- Application 생성 끝 ------------");
		
		/*
		 * 2. Spring Container 객체[ApplicationContext객체]로부터 productService 아이디객체 참조 얻기
		 */
		ProductService productService=(ProductService)applicationContext.getBean("productService");
		System.out.println(productService.productList());
		System.out.println(productService.productDetail(12345));
	}
}
