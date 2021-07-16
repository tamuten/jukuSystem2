package com.example.demo.login.controller.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.example.demo.login.controller.form.TeacherForm;

@Component
public class TeacherFormValidator extends AbstractValidator<TeacherForm> {

	@Override
	protected void doValidate(TeacherForm form, Errors errors) {
		if(StringUtils.isEmpty(form.getUniversity())) {
			if(StringUtils.isNotEmpty(form.getUndergraduate())) {
				errors.rejectValue("university", "teacherForm.emptyUniversity");
			}

			if(StringUtils.isNotEmpty(form.getDepartment())) {

			}
		}

	}

}
