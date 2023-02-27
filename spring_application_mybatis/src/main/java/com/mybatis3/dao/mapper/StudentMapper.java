package com.mybatis3.dao.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectKey;

import com.mybatis3.domain.Student;
@Mapper
public interface StudentMapper {
	/*
	 * 인터페이스의 풀네임은 StudentMapper.xml의 namespace와일치
	 * StudentMapper 인터페이스와 같은 위치에 StudentMapper.xml를 위치시킴 
	 * 메쏘드이름은 	StudentMapper.xml 파일의 id와일치
	 * 메쏘드인자타입은 StudentMapper.xml 파일의 parameterType 와일치
	 * 메쏘드리턴타입은 StudentMapper.xml 파일의 resultType 와일치(ResultSet이 1개이상일경우는 List)
	 */
	public Student findStudentById(Integer studId);
	public List<Student> findAllStudents();
	public String findStudentNameById(Integer studId);
	public List<String> findStudentNameList();
	public int insertStudent(Student student);
	public int insertStudentBySequence1(Student student);
	/*
	<insert id="insertStudentBySequence2" parameterType="com.mybatis3.domain.Student">
		<selectKey order="BEFORE" resultType="int" keyProperty="studId">
			select students_stud_id_seq.nextval from dual
		</selectKey>
		insert into students(stud_id,name,email,dob) values(#{studId},#{name},#{email},#{dob})
	</insert>
	 */
	@SelectKey(statement = "select students_stud_id_seq.nextval from dual", 
			   before=true, keyProperty ="studId", resultType = Integer.class )
	@Insert("insert into students(stud_id,name,email,dob) values(#{studId},#{name},#{email},#{dob})")
	public int insertStudentBySequence2(Student student);		//@Param 기술 안하면 student. 안써도 됨
	public int updateStudentById(Student student);
	public int deleteStudentById(Integer studId);
	public Student findStudentByIdWithAddress(Integer studId);
	
	
}
