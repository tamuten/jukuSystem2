package com.example.demo.login.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.Teacher;
import com.example.demo.login.domain.model.TeacherSubject;
import com.example.demo.login.domain.repository.mybatis.TeacherSubjectMapper;

@Repository
public class TeacherSubjectDao {
	@Autowired
	private TeacherSubjectMapper mapper;

	public void insertBulk(List<String> teacherSubject, String teacherId) {
		mapper.insertBulk(teacherSubject, teacherId);
	}

	public List<TeacherSubject> findOnesSubject(String id) {
		return mapper.findOnesSubject(id);
	}

	public void updateOnesSubject(Teacher teacher) {
//		List<String> subjectList = Arrays.asList(teacher.getSubjectsCanTeach());
		mapper.updateOnesSubject(teacher.getSubjects(), teacher.getId());
	}

	public void deleteOne(String teacherId) {
		mapper.deleteOnesAll(teacherId);
	}
}
