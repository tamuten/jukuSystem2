package com.example.demo.login.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.Grade;
import com.example.demo.login.domain.repository.GradeDao;

@Service
public class ComboboxService {
	@Autowired
	private GradeDao gradeDao;

	public List<Grade> findGrade() {
		return gradeDao.findAll();
	}
}
