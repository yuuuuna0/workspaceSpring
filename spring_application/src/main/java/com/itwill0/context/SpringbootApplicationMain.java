package com.itwill0.context;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.product.ProductService;

@SpringBootApplication
@ComponentScan(basePackages="com.itwill.product")
public class SpringbootApplicationMain {
	public static void main(String[] args) {
		ApplicationContext applicationContext=
				SpringApplication.run(SpringbootApplicationMain.class, args);
		
		ProductService productService=(ProductService)applicationContext.getBean("productService");
		
		System.out.println(productService.productList());
		System.out.println(productService.productDetail(123));
		System.out.println("--------------singleton 객체----------------");
		System.out.println(applicationContext.getBean("productService"));
		System.out.println(applicationContext.getBean("productService"));
		System.out.println(applicationContext.getBean("productService"));
		System.out.println(applicationContext.getBean("productService"));
		
	}
}
