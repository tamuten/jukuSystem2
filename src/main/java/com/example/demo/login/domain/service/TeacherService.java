package com.example.demo.login.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.Teacher;
import com.example.demo.login.domain.repository.TeacherDao;

@Service
public class TeacherService {
	@Autowired
	private TeacherDao dao;

	public List<Teacher> findAll(){
		return dao.findAll();
	}
}
