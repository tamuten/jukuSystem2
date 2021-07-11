package com.example.demo.login.domain.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.login.domain.model.Teacher;

@Mapper
public interface TeacherMapper {
	public void insert(Teacher teacher);
	public List<Teacher> findAll();
	public Teacher selectOne(String id);
	public void updateOne(Teacher teacher);
	public void deleteOne(String id);
}
