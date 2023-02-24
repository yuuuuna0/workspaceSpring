package com.itwill.guest.dao.jdbctemplate;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DuplicateKeyException;
//@SpringBootApplication
@SpringBootTest
class GuestDaoImplJdbcTemplateTest {
	@Autowired
	GuestDao guestDao;
	@Disabled
	@Test
	void testSelectAll() throws Exception{
		assertNotNull(guestDao.selectAll());
		assertNotEquals(guestDao.selectAll().size(), 0);
		System.out.println(guestDao.selectAll());
	}
	@Disabled
	@Test
	void testSelectByNo() throws Exception{
		assertNotNull(guestDao.selectByNo(309));
		System.out.println(guestDao.selectByNo(309));
	}
	@Disabled
	@Test
	void testInsertGuest() {
		try {
			Guest guest=new Guest(0,"집",null,"home@naver.com","WannaGoHome.com","집가고싶어용","1시간30분!!");
			int rowCount=guestDao.insertGuest(guest);
			assertEquals(rowCount, 1);
		} catch (Exception e) {
			assertInstanceOf(DuplicateKeyException.class, e);	//동일한 키에서 에러가 발생
		}
	}
	@Disabled
	@Test
	void testUpdateGuest() throws Exception{
			Guest updateGuest=new Guest(313,"변경",null,"변경@naver.com","변경.com","변경","변경되었을까?");
			int rowCount=guestDao.updateGuest(updateGuest);
			assertEquals(rowCount, 1);
			System.out.println(guestDao.selectByNo(313));
	}
	@Test
	void testDeleteGuest() throws Exception{
		int rowCount=guestDao.deleteGuest(230);
		System.out.println(rowCount);
		//rowCount 영향받은 행의 수
	}

}
