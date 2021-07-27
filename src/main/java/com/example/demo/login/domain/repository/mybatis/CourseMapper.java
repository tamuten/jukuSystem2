package com.example.demo.login.domain.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.login.domain.model.Course;

@Mapper
public interface CourseMapper {
	public void insert(Course course);
	public List<Course> selectMany();
	public Course selectOne(String id);
	public Integer selectClassTimes(String id);
	public void updateOne(String id);
	public void deleteOne(String id);
}
