package com.example.demo.login.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.Employee;
import com.example.demo.login.domain.repository.mybatis.MEmployeeMapper;

@Repository
public class MEmployeeDao {
	@Autowired
	private MEmployeeMapper mapper;

	public Employee selectOne(String id) {
		return mapper.selectOne(id);
	}
}
