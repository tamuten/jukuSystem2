package com.example.demo.login.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.login.Sequence;
import com.example.demo.login.domain.model.Course;
import com.example.demo.login.domain.repository.CourseDao;
import com.example.demo.login.domain.repository.SequenceDao;

@Service
public class CourseService {

	@Autowired
	private SequenceDao sequenceDao;

	@Autowired
	private CourseDao courseDao;

	public String getNextId() {
		int nextId = sequenceDao.getSequence(Sequence.COURSE);
		return String.format("%08d", nextId);
	}

	public void insertOne(Course course) {
		courseDao.insertOne(course);
	}

	public List<Course> selectMany(){
		return courseDao.selectMany();
	}

	public Course selectOne(String id) {
		return courseDao.selectOne(id);
	}

}
