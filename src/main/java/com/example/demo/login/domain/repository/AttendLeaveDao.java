package com.example.demo.login.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.AttendLeave;
import com.example.demo.login.domain.repository.mybatis.AttendLeaveMapper;

@Repository
public class AttendLeaveDao {
	@Autowired
	private AttendLeaveMapper mapper;

	public void insert(AttendLeave attendLeave) {
		mapper.insert(attendLeave);
	}

	public void update(AttendLeave attendLeave) {
		mapper.update(attendLeave);
	}

	public int findAlreadyAttend(AttendLeave attendLeave) {
		return mapper.findAlreadyAttend(attendLeave);
	}
}
