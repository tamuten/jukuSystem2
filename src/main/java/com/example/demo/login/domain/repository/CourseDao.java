package com.example.demo.login.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.Course;
import com.example.demo.login.domain.repository.mybatis.CourseMapper;

@Repository
public class CourseDao {
	@Autowired
	private CourseMapper mapper;

	public void insertOne(Course course) {
		mapper.insert(course);
	}

	public List<Course> selectMany(){
		return mapper.selectMany();
	}

	public Course selectOne(String id) {
		return mapper.selectOne(id);
	}

	public void updateOne(String id) {
		mapper.updateOne(id);
	}
}
