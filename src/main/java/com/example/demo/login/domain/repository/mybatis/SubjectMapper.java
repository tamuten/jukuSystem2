package com.example.demo.login.domain.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.login.domain.model.Subject;

@Mapper
public interface SubjectMapper {
	public List<Subject> findAll();
}
