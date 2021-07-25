package com.example.demo.login.domain.repository.mybatis;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.login.domain.model.ClassSchedule;

@Mapper
public interface ClassScheduleMapper {
	public void insert(ClassSchedule classSchedule);
	public Integer countRow(String yearMonth);
}
