package com.example.demo.login.domain.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.login.domain.model.Student;

@Mapper
public interface StudentMapper {
	public void insert(Student student);
	public List<Student> findAll();
	public Student selectOne(String id);
	public void updateOne(Student student);
	public void deleteOne(String id);
}
