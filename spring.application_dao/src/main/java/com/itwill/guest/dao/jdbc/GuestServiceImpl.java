package com.itwill.guest.dao.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service(value = "guestService")
@Scope("singleton")
public class GuestServiceImpl implements GuestService {
	private GuestDao guestDao;
	
	public GuestServiceImpl() {
		System.out.println("1.#### GuestServiceImpl() 기본생성자");
	}
	
	@Autowired
	public GuestServiceImpl(GuestDao guestDao) {
		this.guestDao=guestDao;
		System.out.println("2-2.#### GuestDaoImpl(GuestDao guestDao) 생성자호출");
	}
	
	@Override
	public List<Guest> selectAll()throws Exception{
		guestDao.selectAll();
		System.out.println("#### GuestServiceImpl : selectAll() 호출");
		return  null;
	}
	@Override
	public Guest selectByNo(int no)throws Exception{
		System.out.println("#### GuestServiceImpl : selectByNo(int no) 호출");
		return null;
	}
	@Override
	public int insertGuest(Guest guest)throws Exception{
		System.out.println("#### GuestServiceImpl : insertGuest(Guest guest) 호출");
		return 0;
	}
	@Override
	public int updateGuest(Guest guest)throws Exception{
		System.out.println("#### GuestServiceImpl : updateGuest(Guest guest) 호출");
		return 0;
	}
	@Override
	public int deleteGuest(int no)throws Exception{
		System.out.println("#### GuestServiceImpl : deleteGuest(int no) 호출");
		return 0;
	}
	
}
