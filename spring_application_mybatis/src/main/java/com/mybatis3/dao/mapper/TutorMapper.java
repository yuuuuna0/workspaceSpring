package com.mybatis3.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.mybatis3.domain.Tutor;

@Mapper
public interface TutorMapper {
	public Tutor findTutorByIdWithCourses(Integer tutorId);
	
}
