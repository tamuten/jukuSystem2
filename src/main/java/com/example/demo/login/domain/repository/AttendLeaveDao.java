package com.example.demo.login.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.AttendLeave;
import com.example.demo.login.domain.model.dto.AttendListDto;
import com.example.demo.login.domain.model.dto.SearchAttendDto;
import com.example.demo.login.domain.repository.mybatis.AttendLeaveMapper;

@Repository
public class AttendLeaveDao {
	@Autowired
	private AttendLeaveMapper mapper;

	public void insert(AttendLeave attendLeave) {
		mapper.insert(attendLeave);
	}

	public void insertLeave(AttendLeave attendLeave) {
		mapper.insertLeave(attendLeave);
	}

	public int update(AttendLeave attendLeave) {
		return mapper.update(attendLeave);
	}

	public boolean isAlreadyAttend(AttendLeave attendLeave) {
		return mapper.findAlreadyAttend(attendLeave) > 0;
	}

	public List<AttendListDto> findAttendance(SearchAttendDto searchAttendDto) {
		return mapper.findAttendance(searchAttendDto);
	}
}
