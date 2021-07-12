package com.example.demo.login.controller.helper;

import org.springframework.beans.BeanUtils;

import com.example.demo.login.controller.form.TeacherForm;
import com.example.demo.login.domain.model.Teacher;

public class TeacherHelper {
	public static Teacher convertFormToTeacher(TeacherForm form) {
		Teacher teacher = new Teacher();
		BeanUtils.copyProperties(form, teacher);
		teacher.setName(form.getLastName() + " " + form.getFirstName());
		teacher.setKana(form.getLastKana() + " " + form.getFirstKana());
		return teacher;
	}
}
