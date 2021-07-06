package com.example.demo.login.domain.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.login.domain.model.Grade;

@Mapper
public interface GradeMapper {
	public List<Grade> findAll();
}
