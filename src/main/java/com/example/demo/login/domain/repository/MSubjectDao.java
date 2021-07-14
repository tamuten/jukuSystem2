package com.example.demo.login.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.Subject;
import com.example.demo.login.domain.repository.mybatis.SubjectMapper;

@Repository
public class MSubjectDao {
	@Autowired
	private SubjectMapper mapper;

	public List<Subject> findAll(){
		return mapper.findAll();
	}
}
