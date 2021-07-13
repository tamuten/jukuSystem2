package com.example.demo.login.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.Grade;
import com.example.demo.login.domain.repository.mybatis.GradeMapper;

@Repository
public class GradeDao {
	@Autowired
	private GradeMapper mapper;

	public List<Grade> findAll() {
		return mapper.findAll();
	}

	public List<Grade> findUnivGrade(){
		return mapper.findUnivGrade();
	}
}
