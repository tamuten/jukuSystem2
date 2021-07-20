package com.example.demo.login.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.Grade;
import com.example.demo.login.domain.model.Subject;
import com.example.demo.login.domain.model.Timed;
import com.example.demo.login.domain.repository.GradeDao;
import com.example.demo.login.domain.repository.MSubjectDao;
import com.example.demo.login.domain.repository.MTimedDao;

@Service
public class ComboboxService {
	@Autowired
	private GradeDao gradeDao;
	@Autowired
	private MSubjectDao mSubjectDao;
	@Autowired
	private MTimedDao mTimedDao;

	public List<Grade> findStudentGrade() {
		return gradeDao.findStudentGrade();
	}

	public List<Grade> findUnivGrade(){
		return gradeDao.findUnivGrade();
	}

	public List<Subject> findAllSubject(){
		return mSubjectDao.findAll();
	}

	public List<Timed> findAllTimed(){
		return mTimedDao.findAll();
	}
}
