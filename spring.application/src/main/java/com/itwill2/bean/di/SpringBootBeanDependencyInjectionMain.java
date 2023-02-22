package com.itwill2.bean.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.itwill.guest.GuestService;
import com.itwill.order.OrderService;
import com.itwill.user.UserService;
import com.itwill1.bean.create.SpringBootBeanCreateApplicationMain;

@SpringBootApplication
@ComponentScan({"com.itwill.guest","com.itwill.user","com.itwill.order"})
public class SpringBootBeanDependencyInjectionMain {

	public static void main(String[] args) throws Exception{
		System.out.println("------ Spring Container 초기화 시작	[ApplicationContext객체 생성 시작] -------");
		ApplicationContext applicationContext=
				SpringApplication.run(SpringBootBeanDependencyInjectionMain.class,args);
		System.out.println("------ Spring Container 초기화 끝	[ApplicationContext객체 생성 끝  ] -------");
		
		System.out.println("------ 1. Constructor 	Injection ------");	//세개 중 권장되는 것
		GuestService guestService=applicationContext.getBean(GuestService.class);
		guestService.selectAll();
		System.out.println("------ 2. Setter 		Injection ------");
		UserService userService=(UserService)applicationContext.getBean(UserService.class);
		userService.create(null);
		System.out.println("------ 3. Field 		Injection ------");
		OrderService orderService=(OrderService)applicationContext.getBean(OrderService.class);
		orderService.list();
		
	}

}
