package com.example.demo.login.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.example.demo.login.controller.form.StudentForm;
import com.example.demo.login.domain.repository.CourseDao;

@Component
public class StudentFormValidator extends AbstractValidator<StudentForm> {
	@Autowired
	private CourseDao courseDao;

	@Override
	protected void doValidate(StudentForm form, Errors errors) {
		Integer canTakeClassWeekly = courseDao.selectClassTimes(form.getCourse());
		Integer takingClassWeekly = form.getClasses().size();
		if(takingClassWeekly > canTakeClassWeekly) {
			errors.rejectValue("", null);
		}
	}

}
