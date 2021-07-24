package com.example.demo.login.domain.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.login.domain.model.StudentClass;

@Mapper
public interface StudentClassMapper {
	public List<StudentClass> findAll();
	public void insertBulk(@Param("scList") List<StudentClass> classes, @Param("studentId") String studentId);
	public void updateOnesClass(@Param("scList") List<StudentClass> classes, @Param("studentId") String studentId);
}
