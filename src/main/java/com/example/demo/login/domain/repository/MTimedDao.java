package com.example.demo.login.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.Timed;
import com.example.demo.login.domain.repository.mybatis.MTimedMapper;

@Repository
public class MTimedDao {
	@Autowired
	private MTimedMapper mapper;

	public List<Timed> findAll() {
		return mapper.findAll();
	}

	public void update(List<Timed> timedList) {
		for (Timed timed : timedList) {
			mapper.updateOne(timed);
		}
	}
}
