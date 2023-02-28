package com.itwill.guest.dao.mybatis_mapper_inerface;



import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
@SpringBootApplication
@MapperScan(basePackages = "com.itwill.guest.dao.mybatis_mapper_inerface.mapper")
public class SpringBootGuestDaoImplMyBatisMapperInterfaceMain {
	public static void main(String[] args) throws Exception{
		System.out.println("----Spring Container초기화시작[ApplicationContext객체생성시작]");
		ApplicationContext applicationContext=SpringApplication.run(SpringBootGuestDaoImplMyBatisMapperInterfaceMain.class, args);
		System.out.println("----Spring Container초기화끝[ApplicationContext객체생성끝]");
		GuestDao guestDao=
				(GuestDao)applicationContext.getBean(GuestDao.class);
		System.out.println(guestDao);
		System.out.println("1.selectAll:"+guestDao.selectAll());
		System.out.println("2.selectByNo:"+guestDao.selectByNo(264));
		Guest newGuest=new Guest(0, "name", null, "email@korea.com", "www.naver.com", "제목", "내용");
		System.out.println("3.insertGuest:"+guestDao.insertGuest(newGuest));
		System.out.println(newGuest);
		Guest guest=guestDao.selectByNo(264);
		guest.setGuestName("김수정");
		guest.setGuestEmail("sujung@gmail.com");
		guest.setGuestDate("2022/05/11");
		System.out.println("4.updateGuest:"+guestDao.updateGuest(guest));
		System.out.println("5.deleteGuest:"+guestDao.deleteGuest(240));
	}

}
