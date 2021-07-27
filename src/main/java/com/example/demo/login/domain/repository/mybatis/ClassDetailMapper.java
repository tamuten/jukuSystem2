package com.example.demo.login.domain.repository.mybatis;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.login.domain.model.ClassDetail;
import com.example.demo.login.domain.model.dto.ClassDetailDto;

@Mapper
public interface ClassDetailMapper {
	public void insert(String yearMonth);
	public List<ClassDetailDto> findClass(Date date);
	public ClassDetail selectOne(Integer id);
	public void delete(@Param("beginOfMonth") Date beginOfMonth, @Param("endOfMonth") Date endOfMonth);
}
