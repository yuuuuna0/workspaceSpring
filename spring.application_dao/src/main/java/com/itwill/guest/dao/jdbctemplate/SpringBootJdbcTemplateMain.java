package com.itwill.guest.dao.jdbctemplate;

import java.sql.Types;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringBootJdbcTemplateMain {

	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext=SpringApplication.run(SpringBootJdbcTemplateMain.class, args);
		JdbcTemplate jdbcTemplate=(JdbcTemplate)applicationContext.getBean(JdbcTemplate.class);
		System.out.println("A. JdbcTemplate : "+jdbcTemplate);
		System.out.println("B. JdbcTemplate DataSource : "+jdbcTemplate.getDataSource());
		System.out.println("C. JdbcTemplate DataSource : "+jdbcTemplate.getDataSource().getConnection());
		
		System.out.println("1. JdbcTemplate 객체 얻기");
		/*
		 * select --> queryForObject() 반환타입[String,Wrapper,DTO(Bean)]
		 */
		//queryForObject[반환타입DTO]
		String selectDtoSql="select * from guest where guest_no=?";
		Object[] paramArray1= {263};
		Object[] paramArray2=new Object[] {263};
		
		BeanPropertyRowMapper<Guest> guestBeanPropertyRowMapper=new BeanPropertyRowMapper<Guest>(Guest.class);
		Guest guest=jdbcTemplate.queryForObject(selectDtoSql,
												new Object[]{263},
												new int[] {Types.INTEGER},
												guestBeanPropertyRowMapper);
		System.out.println("queryForObject[Guest]"+guest);
		/*
		 * select --> query() 반환타입[List<Guest,User>]
		 * cf. select --> queryForList() 반환타입[Map]
		 */
		/*
		 * DML(update,delete,insert) --> update 반환타입[rowCount(int)]
		 */
	}

}
