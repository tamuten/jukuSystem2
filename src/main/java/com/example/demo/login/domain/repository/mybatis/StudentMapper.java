package com.example.demo.login.domain.repository.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.login.domain.model.Student;
import com.example.demo.login.domain.model.dto.StudentListDto;

@Mapper
public interface StudentMapper {
	public void insert(Student student);
	public List<StudentListDto> findAll();
	public Student selectOne(String id);
	public int studentCount(String id);
	public void updateOne(Student student);
	public void deleteOne(String id);
}
