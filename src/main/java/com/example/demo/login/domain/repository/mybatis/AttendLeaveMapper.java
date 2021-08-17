package com.example.demo.login.domain.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.login.domain.model.AttendLeave;

@Mapper
public interface AttendLeaveMapper {
	public void insert(AttendLeave attendLeave);
	public void update(AttendLeave attendLeave);
	public int findAlreadyAttend(AttendLeave attendLeave);
}
