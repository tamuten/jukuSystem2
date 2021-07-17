package com.example.demo.login.controller.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.example.demo.login.controller.form.TeacherForm;

@Component
public class TeacherFormValidator extends AbstractValidator<TeacherForm> {

	@Override
	protected void doValidate(TeacherForm form, Errors errors) {
		if (StringUtils.isEmpty(form.getUniversity())) {
			if (StringUtils.isNotEmpty(form.getUndergraduate()) && StringUtils.isNotEmpty(form.getDepartment())) {
				errors.rejectValue("university", "teacherForm.emptyUniversity");
			} else if (StringUtils.isNotEmpty(form.getUndergraduate())) {
				errors.rejectValue("university", "teacherForm.emptyUniversity");
			} else if (StringUtils.isNotEmpty(form.getDepartment())) {
				errors.rejectValue("university", "teacherForm.emptyUniversity");
				errors.rejectValue("undergraduate", "teacherForm.emptyUndergraduate");
			}
		} else {
			if (StringUtils.isEmpty(form.getUndergraduate()) && StringUtils.isNotEmpty(form.getDepartment())) {
				errors.rejectValue("undergraduate", "teacherForm.emptyUndergraduate");
			}
		}

	}

}
