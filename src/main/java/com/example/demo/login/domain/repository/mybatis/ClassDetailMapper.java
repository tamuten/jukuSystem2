package com.example.demo.login.domain.repository.mybatis;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.login.domain.model.dto.ClassDetailDto;

@Mapper
public interface ClassDetailMapper {
	public void insert();
	public List<ClassDetailDto> findClass(Date date);
}
