package com.example.demo.login.domain.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.login.domain.model.Employee;

@Mapper
public interface MEmployeeMapper {
	public Employee selectOne(String id);
}
