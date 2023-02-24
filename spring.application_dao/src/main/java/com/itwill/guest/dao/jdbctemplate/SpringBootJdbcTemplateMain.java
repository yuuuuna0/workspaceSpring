package com.itwill.guest.dao.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

@SpringBootApplication
public class SpringBootJdbcTemplateMain {

	public static void main(String[] args) throws Exception{
		ApplicationContext applicationContext=SpringApplication.run(SpringBootJdbcTemplateMain.class, args);
		JdbcTemplate jdbcTemplate=(JdbcTemplate)applicationContext.getBean(JdbcTemplate.class);
		System.out.println("A. JdbcTemplate : "+jdbcTemplate);
		System.out.println("B. JdbcTemplate DataSource : "+jdbcTemplate.getDataSource());
		System.out.println("C. JdbcTemplate DataSource : "+jdbcTemplate.getDataSource().getConnection());
		
		System.out.println("1. JdbcTemplate 객체 얻기");
		
		/*********************************************************************
		 * select --> queryForObject() 반환타입[String,Wrapper,DTO(Bean)]
		 **********************************************************************/
		/*
		 * <<BeanPropertyRowMapper>>
		 * 		1. ResultSet객체로부터 컬럼이름으로 데이터를 get 해서 Guest 객체 생성 후 
		 * 		   테이블 컬럼 이름과 동일한 이름의 Guest 객체의 property(멤버변수)를 찾아 
		 * 		   해당 property에 대입해주는 클래스
		 * 		2. CamelCase와 SnailCase는 호환 가능 ex.guest_email <=> guestEmail
		 */
		BeanPropertyRowMapper<Guest> guestBeanPropertyRowMapper=new BeanPropertyRowMapper<Guest>(Guest.class);
		
		//customizing Mapper
		RowMapper<Guest> guestMapper=new RowMapper<Guest>() {
			@Override
			public Guest mapRow(ResultSet rs, int rowNum) throws SQLException{
				Guest guest=new Guest(rs.getInt("guest_no"),"","","","","","");
				return guest;
			}
		};

		//queryForObject[반환타입 DTO]
		String selectDtoSql="select * from guest where guest_no=?";
		Object[] paramArray1= {309};
		Object[] paramArray2=new Object[] {309};
		Guest guest=jdbcTemplate.queryForObject(selectDtoSql,
												new Object[]{309},
												new int[] {Types.INTEGER},
												guestBeanPropertyRowMapper);
		System.out.println("#### queryForObject[Guest]"+guest);
		//queryForObject[반환타입 String Wrapper]
		String selectStringSql="select guest_name from guest where guest_no=?";
		String guest_name=jdbcTemplate.queryForObject(selectStringSql,
													  paramArray1,
													  new int[] {Types.INTEGER},
													  String.class);
		System.out.println("#### queryForObject[String]"+guest_name);
		
		
		/************************************************************************
		 * select --> query() 반환타입[List<Guest,User>]
		 ***********************************************************************/
		//query[반환타입 List<Guest>]
		String selectDtoListSql="select * from guest";
		List<Guest> guestList=jdbcTemplate.query(selectDtoListSql, guestMapper);
		System.out.println("#### "+guestList.size());
		System.out.println("#### query[List<Guest>]"+guestList);
		
		/************************************************************************
		 * select --> queryForList() 반환타입[List<String,Wrapper>]
		 ***********************************************************************/
		String selectStringListSql="select guest_name from guest";
		List<String> guest_nameList=jdbcTemplate.queryForList(selectStringListSql,String.class);
		System.out.println("#### queryForList[List<String>] : "+guest_nameList);
		
		/************************************************************************
		 * select --> queryForMap() 반환타입[Map<String,Object>]
		 ***********************************************************************/
		String selectMapSql="select * from guest where guest_no=?";
		Map rowMap=jdbcTemplate.queryForMap(selectMapSql,paramArray2,new int[] {Types.INTEGER});
		System.out.println("#### queryForMap 반환타입[Map<String,Object>] : "+rowMap);

		String selectMapListSql="select * from guest";
		List rowMapList=jdbcTemplate.queryForList(selectMapListSql);
		System.out.println("#### queryForMap 반환타입[List<Map<String,Object>>] : "+rowMapList);
		
		/************************************************************************
		 * DML(update,delete,insert) --> update 반환타입[rowCount(int)]
		 ************************************************************************/
		String insertSql="insert into guest values(guest_no_seq.nextval,?,sysdate,?,?,?,?)";
		int rowCount=jdbcTemplate.update(insertSql,"접니다","naya@naver.com","나야나.com","나다","안녕하세요 나야");
		System.out.println("#### insert row count: "+rowCount);
		String updateSql="update guest set guest_name=?, guest_email=?, guest_homepage=?, guest_title=?, guest_content=? where guest_no=?";
		rowCount=jdbcTemplate.update(updateSql,"넙니다","neoya@gmail.com","너야너.com","너다","안녕하세요 너예요",310);
		System.out.println("#### update row count: "+rowCount);
		String deleteSql="delete from guest where guest_no=?";
		rowCount=jdbcTemplate.update(deleteSql,310);
		System.out.println("#### delete row count: "+rowCount);
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}

}
