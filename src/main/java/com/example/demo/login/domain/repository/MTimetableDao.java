package com.example.demo.login.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.Timetable;
import com.example.demo.login.domain.repository.mybatis.MTimetableMapper;

@Repository
public class MTimetableDao {
	@Autowired
	private MTimetableMapper mapper;

	public List<Timetable> findAll(){
		return mapper.findAll();
	}
}
