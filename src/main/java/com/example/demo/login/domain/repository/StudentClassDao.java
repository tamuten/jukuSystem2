package com.example.demo.login.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.StudentClass;
import com.example.demo.login.domain.repository.mybatis.StudentClassMapper;

@Repository
public class StudentClassDao {
	@Autowired
	private StudentClassMapper mapper;

	public List<StudentClass> findAll(){
		return mapper.findAll();
	}

	public void insertBulk(List<StudentClass> classes, String studentId) {
		mapper.insertBulk(classes, studentId);
	}

	public void updateOnesClass(List<StudentClass> classes, String studentId) {
		mapper.updateOnesClass(classes, studentId);
	}
}
