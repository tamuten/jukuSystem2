package com.example.demo.login.controller.helper;

import java.sql.Date;

import org.springframework.beans.BeanUtils;

import com.example.demo.login.controller.form.TeacherForm;
import com.example.demo.login.domain.model.Teacher;

public class TeacherHelper {
	public static Teacher convertFormToTeacher(TeacherForm form) {
		Teacher teacher = new Teacher();
		BeanUtils.copyProperties(form, teacher);
		teacher.setName(form.getLastName() + " " + form.getFirstName());
		teacher.setKana(form.getLastKana() + " " + form.getFirstKana());
		if (form.getBirthday() != null) {
			teacher.setBirthday(new Date(form.getBirthday().getTime()));
		}
		return teacher;
	}

	public static void convertTeacherToForm(Teacher teacher, TeacherForm form) {
		BeanUtils.copyProperties(teacher, form);
		String[] name = teacher.getName().split(" ");
		form.setLastName(name[0]);
		form.setFirstName(name[1]);
		String[] kana = teacher.getKana().split(" ");
		form.setLastKana(kana[0]);
		form.setFirstKana(kana[1]);
	}
}
