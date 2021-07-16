package com.example.demo.login.domain.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.login.domain.model.TeacherSubject;

@Mapper
public interface TeacherSubjectMapper {
	public void insertBulk(@Param("tsList") List<TeacherSubject> teacherSubjectList);
	public List<TeacherSubject> findOnesSubject(String teacherId);
	public void updateOnesSubject(@Param("tsList") List<String> subjectList, @Param("teacherId") String teacherId);
	public void deleteOnesAll(String teacherId);
}
