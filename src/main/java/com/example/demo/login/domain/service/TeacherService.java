package com.example.demo.login.domain.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.login.Sequence;
import com.example.demo.login.controller.form.TeacherForm;
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
	private TeacherSubjectDao teacherSubjectDao;
	@Autowired
	private SequenceDao sequenceDao;

	public List<Teacher> findAll() {
		return teacherDao.findAll();
	}

	public void logicCheck(TeacherForm form) {
		// 大学名が未入力で学部名学科名いずれか入力はエラー
		if(StringUtils.isEmpty(form.getUniversity())) {
			if(StringUtils.isNotEmpty(form.getUndergraduate()) || StringUtils.isNotEmpty(form.getDepartment())) {
				// エラー処理
			}
		}

		// 学部名が未入力で学科名が入力はエラー
	}

	public String getNextId() {
		int nextId = sequenceDao.getSequence(Sequence.TEACHER);
		return String.format("%08d", nextId);
	}

	public void insert(Teacher teacher) {
		String teacherId = teacher.getId();
		//		List<Subject> subjectList = teacher.getSubjectsCanTeach();
		String[] teacherSubject = teacher.getSubjectsCanTeach();

		teacherDao.insert(teacher);
		teacherSubjectDao.insertBulk(generateTeacherSubject(teacherId, teacherSubject));
	}

	private List<TeacherSubject> generateTeacherSubject(String teacherId, String[] subjectList) {
		List<TeacherSubject> teacherSubject = new ArrayList<>();
		for (String subjectId : subjectList) {
			TeacherSubject ts = new TeacherSubject(teacherId, subjectId);
			teacherSubject.add(ts);
		}
		return teacherSubject;
	}

	public Teacher selectOne(String id) {
		Teacher teacher = teacherDao.selectOne(id);
		List<TeacherSubject> teacherSubject = teacherSubjectDao.findOnesSubject(id);
		String[] subjectList = teacherSubject.stream().map(ts -> ts.getSubjectId()).toArray(String[] :: new);
		teacher.setSubjectsCanTeach(subjectList);

		return teacher;
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
