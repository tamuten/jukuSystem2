package com.example.demo.login.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.login.Sequence;
import com.example.demo.login.domain.model.Subject;
import com.example.demo.login.domain.model.Teacher;
import com.example.demo.login.domain.model.TeacherSubject;
import com.example.demo.login.domain.repository.SequenceDao;
import com.example.demo.login.domain.repository.TeacherDao;
import com.example.demo.login.domain.repository.TeacherSubjectDao;

@Service
@Transactional
public class TeacherService {
	@Autowired
	private TeacherDao teacherDao;
	@Autowired
	private TeacherSubjectDao tsDao;
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
		String teacherId = teacher.getId();
		List<Subject> subjectList = teacher.getSubjectsCanTeach();

		teacherDao.insert(teacher);
		//		tsDao.insert(generateTeacherSubject(teacherId, subjectList));
	}

	private List<TeacherSubject> generateTeacherSubject(String teacherId, List<Subject> subjectList) {
		List<TeacherSubject> teacherSubject = new ArrayList<>();
		for (Subject subject : subjectList) {
			TeacherSubject ts = new TeacherSubject(teacherId, subject.getId());
			teacherSubject.add(ts);
		}
		return teacherSubject;
	}
}
