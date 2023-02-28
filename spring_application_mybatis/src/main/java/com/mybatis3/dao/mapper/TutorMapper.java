package com.mybatis3.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.mybatis3.domain.Course;
import com.mybatis3.domain.Tutor;

@Mapper
public interface TutorMapper {
	/*
	 * <select id="findTutorByIdWithCourses" 
	 *  	   parameterType="int" 
	 *  	   resultMap="tutorWithCoursesResultMap">
		select t.tutor_id,t.name as tutor_name,t.email,course_id,c.name as course_name,description,start_date,end_date
		from tutors t 
		join courses c 
		on c.tutor_id=t.tutor_id 
		where t.tutor_id=#{tutorId}
	</select>
	 */
	
	@ResultMap("tutorWithCoursesResultMap")
	@Select("select t.tutor_id,t.name as tutor_name,t.email,course_id,c.name as course_name,description,start_date,end_date\r\n"
			+ "		from tutors t join courses c on c.tutor_id=t.tutor_id where t.tutor_id=#{tutorId}")
	public Tutor findTutorByIdWithCourses(Integer tutorId); 
}
