package com.itwill.guest;

import java.util.ArrayList;
import java.util.List;

public interface GuestDao {

	List<Guest> selectAll() throws Exception;

	Guest selectByNo(int no) throws Exception;

	int insertGuest(Guest guest) throws Exception;

	int updateGuest(Guest guest) throws Exception;

	int deleteGuest(int no) throws Exception;

}