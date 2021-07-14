package com.example.demo.login.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.TeacherSubject;
import com.example.demo.login.domain.repository.mybatis.TeacherSubjectMapper;

@Repository
public class TeacherSubjectDao {
	@Autowired
	private TeacherSubjectMapper mapper;

	public void insertBulk(List<TeacherSubject> teacherSubject) {
		mapper.insertBulk(teacherSubject);
	}

	public List<TeacherSubject> findOnesSubject(String id) {
		return mapper.findOnesSubject(id);
	}
}
