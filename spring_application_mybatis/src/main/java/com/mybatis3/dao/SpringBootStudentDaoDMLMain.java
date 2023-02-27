package com.mybatis3.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mybatis3.domain.Student;

@SpringBootApplication
@MapperScan(basePackages = "com.mybatis3.dao.mapper")
public class SpringBootStudentDaoDMLMain {
	public static void main(String[] args) throws Exception{
		ApplicationContext appicationContext=
				SpringApplication.run(SpringBootStudentDaoDMLMain.class, args);
		StudentDao studentDao=(StudentDao)appicationContext.getBean(StudentDao.class);
		System.out.println("---------insertStudent(Dto)--------------------------");
		Student student1= new Student(1111,"화이팅","fighting@naver.com",new Date());
		System.out.println("#### rowCount: "+studentDao.insertStudent(student1));
		System.out.println("---------insertStudentBySequence1--------------------");
		Student student2= new Student(0,"금요일","friday@naver.com",new Date());
		System.out.println("#### rowCount: "+studentDao.insertStudentBySequence1(student2));
		System.out.println("#### pk: "+student2.getStudId());
		System.out.println("#### : "+student2.getStudId()+"번: "+studentDao.findStudentById(student2.getStudId()));
		System.out.println("---------insertStudentBySequence2--------------------");
		Student student3= new Student(0,"시퀀스2","sequence3@naver.com",new Date());
		System.out.println("#### rowCount: "+studentDao.insertStudentBySequence2(student3));
		System.out.println("#### pk: "+student3.getStudId());
		System.out.println("#### : "+student3.getStudId()+"번: "+studentDao.findStudentById(student3.getStudId()));
		System.out.println("---------updateStudentById---------------------------");
		Student updateStudent=studentDao.findStudentById(7);
		updateStudent.setName("변경");
		updateStudent.setEmail("change@gmail.com");
		updateStudent.setDob(new SimpleDateFormat("yyyy/MM/dd").parse("2000/02/02"));
		System.out.println("#### update rowCount: "+studentDao.updateStudentById(updateStudent));
		System.out.println("---------deleteStudentById---------------------------");
		System.out.println("#### delete rowCount: "+studentDao.deleteStudentById(8));
		System.out.println("---------deleteStudentByName-------------------------");
		System.out.println("---------deleteStudentByNameLike---------------------");
	}
}