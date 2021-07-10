package com.example.demo.login.domain.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.login.domain.model.Timed;

@Mapper
public interface MTimedMapper {
	public List<Timed> findAll();

	public void updateOne(Timed timed);
}
