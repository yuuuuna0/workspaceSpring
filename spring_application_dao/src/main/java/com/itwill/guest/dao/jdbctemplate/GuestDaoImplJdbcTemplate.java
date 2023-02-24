package com.itwill.guest.dao.jdbctemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
/*
이름             널?       유형             
-------------- -------- -------------- 
GUEST_NO       NOT NULL NUMBER(10)     
GUEST_NAME     NOT NULL VARCHAR2(50)   
GUEST_DATE     NOT NULL DATE           
GUEST_EMAIL             VARCHAR2(50)   
GUEST_HOMEPAGE          VARCHAR2(50)   
GUEST_TITLE    NOT NULL VARCHAR2(100)  
GUEST_CONTENT  NOT NULL VARCHAR2(4000) 
*/
@Repository
public class GuestDaoImplJdbcTemplate implements GuestDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Guest> selectAll() throws Exception {
		return jdbcTemplate.query(GuestSQL.GUEST_SELECT_ALL, new BeanPropertyRowMapper<Guest>(Guest.class));
	}

	@Override
	public Guest selectByNo(int no) throws Exception {
		return jdbcTemplate.queryForObject(GuestSQL.GUEST_SELECT_BY_NO, 
										   new Object[] {no},
										   new int[] {Types.INTEGER},
										   new BeanPropertyRowMapper<Guest>(Guest.class));
	}

	@Override
	public int insertGuest(Guest guest) throws Exception {
		return jdbcTemplate.update(GuestSQL.GUEST_INSERT,
								   guest.getName(),guest.getGuestEmail(),guest.getGuest_homepage(),guest.getGuest_title(),guest.getGuest_content());
	}

	@Override
	public int updateGuest(Guest guest) throws Exception {
		return jdbcTemplate.update(GuestSQL.GUEST_UPDATE,
								   guest.getName(),guest.getGuestEmail(),guest.getGuest_homepage(),guest.getGuest_title(),guest.getGuest_content(),guest.getGuest_no());
	}

	@Override
	public int deleteGuest(int no) throws Exception {
		return jdbcTemplate.update(GuestSQL.GUEST_DELETE,no);
	}
	
}
