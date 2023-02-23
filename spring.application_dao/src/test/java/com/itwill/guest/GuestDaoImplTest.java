package com.itwill.guest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
//@SpringBootApplication
@SpringBootTest
class GuestDaoImplTest {
	
	@Autowired
	GuestDao guestDao;

	@Disabled
	@Test
	void testSelectAll() throws Exception{
		assertNotEquals(guestDao.selectAll(), null);
		assertNotEquals(guestDao.selectAll().size(),0);
		
		System.out.println(guestDao.selectAll().size());
		System.out.println(guestDao.selectAll());
	}
	@Disabled
	@Test
	void testSelectByNo() throws Exception{
		assertNull(guestDao.selectByNo(11234));
		assertNotNull(guestDao.selectByNo(196));
		assertEquals(guestDao.selectByNo(196).getGuest_name(),"요셉짱");
		System.out.println(guestDao.selectByNo(196));
	}
	@Disabled
	@Test
	void testInsertGuest() throws Exception{
		Guest insertGuest=
				new Guest(0, "테스트", null, "asdf@gmail.com", "test.com", "테스트제목", "테스트다");
		assertEquals(guestDao.insertGuest(insertGuest),1);
	}
	
	@Test
	void testUpdateGuest() throws Exception{
		Guest updateGuest=
				new Guest(263, "테스트수정", null, "asdftf@gmail.com", "testchange.com", "테스트수정제목", "수정한테스트다");
		int updateRowCount=guestDao.updateGuest(updateGuest);
		if(updateRowCount!=1) {
			fail("update 실패");
		}
		
	}

}
