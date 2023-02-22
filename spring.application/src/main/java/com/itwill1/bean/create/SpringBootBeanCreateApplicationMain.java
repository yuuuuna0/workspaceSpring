package com.itwill1.bean.create;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
/*
 * 현재 클래스가 위치하는 패키지와 하위 패키지 클래스의 
 * @Annotation을 스캔하여 초기화(객체생성,의존성주입)
 */
@SpringBootApplication
/*
@ComponentScan(basePackages = {"com.itwill.guest"} )	-- 하나일 경우 중괄호 없어도 되긴 함
@ComponentScan(value = {"com.itwill.guest"} )
*/
@ComponentScan(basePackages ={"com.itwill.guest","com.itwill.user"})
public class SpringBootBeanCreateApplicationMain {

	public static void main(String[] args) {
		System.out.println("------ Spring Container 초기화 시작	[ApplicationContext객체 생성 시작] -------");
		ApplicationContext applicationContext=
				SpringApplication.run(SpringBootBeanCreateApplicationMain.class);
		System.out.println("------ Spring Container 초기화 끝	[ApplicationContext객체 생성 끝  ] -------");

	}

}
