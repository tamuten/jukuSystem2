package com.example.demo.login.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.ClassSchedule;
import com.example.demo.login.domain.repository.mybatis.ClassScheduleMapper;

@Repository
public class ClassScheduleDao {
	@Autowired
	private ClassScheduleMapper mapper;

	public void insert(ClassSchedule classSchedule) {
		mapper.insert(classSchedule);
	}

	public Integer countRow(String yearMonth) {
		return mapper.countRow(yearMonth);
	}

	public void delete(String yearMonth) {
		mapper.delete(yearMonth);
	}
}
