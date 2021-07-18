package com.example.demo.login.domain.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.login.domain.model.Timetable;

@Mapper
public interface MTimetableMapper {
	public List<Timetable> findAll();
	public void update(List<Timetable> timetable);
}
