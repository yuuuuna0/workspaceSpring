package com.mybatis3.basic;


import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mybatis3.basic.mapper.StudentBasicMapper;
/*
스프링 부트 메인 어플리케이션에 @MapperScan을 이용해 
스프링 부트가 @Mapper가 붙은 MyBatis 매퍼를 스캔하여 
빈으로 등록할 수 있도록 한다.
 */
@SpringBootApplication
@MapperScan(basePackages="com.mybatis3.basic.mapper")
public class SpringBootMyBatisMapperInterfaceFlowMain {

	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext=
				SpringApplication.run(SpringBootMyBatisMapperInterfaceFlowMain.class, args);
		/*
		 * 1. StudentBasicMapper객체얻기
		 * 	-com.mybatis.dao.mapper.dao.mapper.StudentBasicMapper인터페이스를 구현한 객체 얻기 
		 */
		
		System.out.println("1. #### StudentMapper객체얻기:");
		StudentBasicMapper studentBasicMapper = 
				(StudentBasicMapper)applicationContext
				.getBean(StudentBasicMapper.class);
		System.out.println(studentBasicMapper);
		/*
		 * 2. StudentMapper사용(CRUD)
		 * 	-com.mybatis3.dao.mapper.StudentBasicMapper인터페이스를 구현한객체의메쏘드호출
		 */
		System.out.println("#### findStudent:" +studentBasicMapper.findStudent(3));
	
		System.out.println("#### studentList:"+studentBasicMapper.studentList());
	
	}
}













