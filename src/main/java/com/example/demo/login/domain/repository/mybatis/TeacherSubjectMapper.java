package com.example.demo.login.domain.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.login.domain.model.TeacherSubject;

@Mapper
public interface TeacherSubjectMapper {
	public void insert(TeacherSubject teacherSubject);
	public List<TeacherSubject> findOnesSubject(String teacherId);
	public void deleteOnesSubject(List<TeacherSubject> teacherSubjects);
	public void deleteOnesAll(String teacherId);
}
