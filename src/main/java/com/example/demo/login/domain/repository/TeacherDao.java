package com.example.demo.login.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.Teacher;
import com.example.demo.login.domain.repository.mybatis.TeacherMapper;

@Repository
public class TeacherDao {
	@Autowired
	private TeacherMapper teacherMapper;

	public List<Teacher> findAll() {
		return teacherMapper.findAll();
	}

	public void insert(Teacher teacher) {
		teacherMapper.insert(teacher);
	}

	public Teacher selectOne(String id) {
//		return teacherMapper.selectOne(id);
		return teacherMapper.select(id);
	}

	public void updateOne(Teacher teacher) {
		teacherMapper.updateOne(teacher);
	}

	public void deleteOne(String id) {
		teacherMapper.deleteOne(id);
	}
}
