package com.example.demo.login.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.Student;
import com.example.demo.login.domain.repository.mybatis.StudentMapper;

@Repository
public class StudentDao {
	@Autowired
	private StudentMapper mapper;

	public void insertOne(Student student) {
		mapper.insert(student);
	}

	public List<Student> findAll(){
		return mapper.findAll();
	}

	public Student selectOne(String id) {
		return mapper.selectOne(id);
	}

	public void updateOne(Student student) {
		mapper.updateOne(student);
	}

	public void deleteOne(String id) {
		mapper.deleteOne(id);
	}
}
