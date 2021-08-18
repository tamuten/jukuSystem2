package com.example.demo.login.domain.repository.mybatis;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.login.domain.model.AttendLeave;
import com.example.demo.login.domain.model.dto.AttendListDto;

@Mapper
public interface AttendLeaveMapper {
	public void insert(AttendLeave attendLeave);
	public void insertLeave(AttendLeave attendLeave);
	public int update(AttendLeave attendLeave);
	public int findAlreadyAttend(AttendLeave attendLeave);
	public List<AttendListDto> findAttendance(Date date);
}
