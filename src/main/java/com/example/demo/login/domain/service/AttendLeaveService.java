package com.example.demo.login.domain.service;

import java.util.Locale;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import com.example.demo.login.Message;
import com.example.demo.login.controller.form.AttendForm;
import com.example.demo.login.domain.model.AttendLeave;
import com.example.demo.login.domain.repository.AttendLeaveDao;

@Service
public class AttendLeaveService {
	@Autowired
	private AttendLeaveDao attendLeaveDao;
	@Autowired
	private MessageSource messageSource;

	public void formCheckBeforeAttend(AttendForm form) {
		AttendLeave attendLeave = new AttendLeave();
		BeanUtils.copyProperties(form, attendLeave);
		// 既に登校している
		if (attendLeaveDao.isAlreadyAttend(attendLeave)) {
			form.addError(messageSource.getMessage(Message.ISALREADYATTENDANCE.getKey(), null, Locale.JAPAN));
		}
	}

	public void leave(AttendLeave attendLeave) {
		int updateRow = attendLeaveDao.update(attendLeave);
		if (updateRow < 1) {
			attendLeaveDao.insertLeave(attendLeave);
		}
	}
}
