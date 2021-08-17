package com.example.demo.login.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.login.domain.model.AttendLeave;
import com.example.demo.login.domain.repository.AttendLeaveDao;

@Service
public class AttendLeaveService {
	@Autowired
	private AttendLeaveDao attendLeaveDao;

	public void formCheck(AttendLeave attendLeave, Model model) {

		if (attendLeaveDao.findAlreadyAttend(attendLeave) < 1) {

		}
	}
}
