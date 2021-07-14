package com.example.demo.login.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.Grade;
import com.example.demo.login.domain.model.Subject;
import com.example.demo.login.domain.repository.GradeDao;
import com.example.demo.login.domain.repository.MSubjectDao;

@Service
public class ComboboxService {
	@Autowired
	private GradeDao gradeDao;
	@Autowired
	private MSubjectDao mSubjectDao;

	public List<Grade> findStudentGrade() {
		return gradeDao.findStudentGrade();
	}

	public List<Grade> findUnivGrade(){
		return gradeDao.findUnivGrade();
	}

	public List<Subject> findAllSubject(){
		return mSubjectDao.findAll();
	}
}
