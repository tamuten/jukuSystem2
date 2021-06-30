package com.example.demo.login.domain.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.login.domain.model.Lesson;

@Mapper
public interface LessonMapper {
	public boolean insert(Lesson lesson);

	public Lesson selectOne(Integer id);

	public List<Lesson> selectMany();

}
