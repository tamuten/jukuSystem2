package com.example.demo.login.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.login.Sequence;
import com.example.demo.login.domain.model.Teacher;
import com.example.demo.login.domain.repository.SequenceDao;
import com.example.demo.login.domain.repository.TeacherDao;
import com.example.demo.login.domain.repository.TeacherSubjectDao;

@Service
@Transactional
public class TeacherService {
	@Autowired
	private TeacherDao teacherDao;
	@Autowired
	private TeacherSubjectDao teacherSubjectDao;
	@Autowired
	private SequenceDao sequenceDao;

	public List<Teacher> findAll() {
		return teacherDao.findAll();
	}

	public String getNextId() {
		int nextId = sequenceDao.getSequence(Sequence.TEACHER);
		return String.format("%08d", nextId);
	}

	public void insert(Teacher teacher) {
		teacherDao.insert(teacher);
		teacherSubjectDao.insertBulk(teacher.getSubjects(), teacher.getId());
	}

	public Teacher selectOne(String id) {
		return teacherDao.selectOne(id);
	}

	public void updateOne(Teacher teacher) {
		teacherDao.updateOne(teacher);
		teacherSubjectDao.updateOnesSubject(teacher);
	}

	public void deleteOne(String id) {
		teacherDao.deleteOne(id);
		teacherSubjectDao.deleteOne(id);
	}

}
