package com.example.demo.login.domain.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.ClassDetail;
import com.example.demo.login.domain.model.dto.ClassDetailDto;
import com.example.demo.login.domain.repository.mybatis.ClassDetailMapper;

@Repository
public class ClassDetailDao {
	@Autowired
	private ClassDetailMapper mapper;

	public void insert(String yearMonth) {
		mapper.insert(yearMonth);
	}

	public List<ClassDetailDto> findClass(Date date) {
		return mapper.findClass(date);
	}

	public ClassDetail selectOne(Integer id) {
		return mapper.selectOne(id);
	}

	public void delete(Date beginOfMonth, Date endOfMonth) {
		mapper.delete(beginOfMonth, endOfMonth);
	}
}
