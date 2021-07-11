package com.example.demo.login.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.Teacher;
import com.example.demo.login.domain.repository.mybatis.TeacherMapper;
import com.example.demo.login.domain.repository.mybatis.TeacherSubjectMapper;

@Repository
public class TeacherDao {
	@Autowired
	private TeacherMapper teacherMapper;
	@Autowired
	private TeacherSubjectMapper tsMapper;

	public List<Teacher> findAll(){
		return teacherMapper.findAll();
	}
}
