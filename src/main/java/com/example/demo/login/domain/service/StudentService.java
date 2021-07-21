package com.example.demo.login.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.login.Sequence;
import com.example.demo.login.domain.model.Student;
import com.example.demo.login.domain.model.dto.StudentListDto;
import com.example.demo.login.domain.repository.SequenceDao;
import com.example.demo.login.domain.repository.StudentClassDao;
import com.example.demo.login.domain.repository.StudentDao;

@Service
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private StudentClassDao studentClassDao;
	@Autowired
	private SequenceDao sequenceDao;

	public String getNextId() {
		int nextId = sequenceDao.getSequence(Sequence.STUDENT);
		return String.format("%08d", nextId);
	}

	public void insertOne(Student student) {
		studentDao.insertOne(student);
		studentClassDao.insertBulk(student.getClasses(), student.getId());
	}

	public List<StudentListDto> findAll() {
		return studentDao.findAll();
	}

	public Student selectOne(String id) {
		return studentDao.selectOne(id);
	}

	public void updateOne(Student student) {
		studentDao.updateOne(student);
		studentClassDao.updateOnesClass(student.getClasses(), student.getId());
	}

	public void deleteOne(String id) {
		studentDao.deleteOne(id);
	}

}
