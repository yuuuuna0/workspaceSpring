package com.itwill.guest.dao.mybatis;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
@SpringBootApplication
@SpringBootTest
class GuestDaoImplMyBatisTest {
	@Autowired
	private GuestDao guestDao;

	@Test
	void init() {
		System.out.println(guestDao);
	}
	//@Transactional	//test시행 후 rollback함
	//@Test
	void testSelectAll() throws Exception{
		System.out.println(guestDao.selectAll());
	}

	//@Test
	void testSelectByNo() throws Exception{
		System.out.println(guestDao.selectByNo(6));
	}
	@Transactional
	@Test
	void testInsertGuest() throws Exception{
		Guest guest=new Guest(0,"김김김",null,"김김김@naver.com","김김김.com","김김김","Null나와");
		System.out.println(guestDao.insertGuest(guest));
	}

	void testUpdateGuest() {
		fail("Not yet implemented");
	}

	void testDeleteGuest() {
		fail("Not yet implemented");
	}

}
