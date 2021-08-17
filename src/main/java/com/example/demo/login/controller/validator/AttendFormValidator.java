package com.example.demo.login.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.example.demo.login.controller.form.AttendForm;
import com.example.demo.login.domain.repository.StudentDao;

@Component
public class AttendFormValidator extends AbstractValidator<AttendForm> {
	@Autowired
	private StudentDao studentDao;

	@Override
	protected void doValidate(AttendForm form, Errors errors) {
		// 存在しない生徒IDが入力された場合エラー
		if (studentDao.studentCount(form.getStudentId()) < 1) {
			errors.rejectValue("studentId", "attendForm.invalidId");
		}
	}

}
