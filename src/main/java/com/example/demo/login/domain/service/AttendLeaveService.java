package com.example.demo.login.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.login.Message;
import com.example.demo.login.domain.model.AttendLeave;
import com.example.demo.login.domain.repository.AttendLeaveDao;

@Service
public class AttendLeaveService {
	@Autowired
	private AttendLeaveDao attendLeaveDao;
	@Autowired
	MessageSource messageSource;

	public void formCheck(AttendLeave attendLeave, Model model) {
		List<String> errorList = new ArrayList<>();
		if (attendLeaveDao.findAlreadyAttend(attendLeave) > 1) {
			errorList.add(messageSource.getMessage(Message.ISALREADYATTENDANCE.getKey(), null, Locale.JAPAN));
		}
		model.addAttribute("error", errorList);
	}
}
