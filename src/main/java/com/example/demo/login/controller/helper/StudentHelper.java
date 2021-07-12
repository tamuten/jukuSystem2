package com.example.demo.login.controller.helper;

import java.sql.Date;

import org.springframework.beans.BeanUtils;

import com.example.demo.login.controller.form.StudentForm;
import com.example.demo.login.domain.model.Student;

public class StudentHelper {
	/**
	 * FormからStudentに値を渡す。
	 *
	 * @param form
	 * @return Student
	 */
	public static Student convertFormToStudent(StudentForm form) {
		Student student = new Student();
		BeanUtils.copyProperties(form, student);
		student.setName(form.getLastName() + " " + form.getFirstName());
		student.setKana(form.getLastKana() + " " + form.getFirstKana());
		if (form.getBirthday() != null) {
			student.setBirthday(new Date(form.getBirthday().getTime()));
		}
		return student;
	}

	/**
	 * StudentからFormに値を渡す
	 *
	 * @param student
	 * @param form
	 */
	public static void convertStudentToForm(Student student, StudentForm form) {
		BeanUtils.copyProperties(student, form);
		String[] name = student.getName().split(" ");
		form.setLastName(name[0]);
		form.setFirstName(name[1]);
		String[] kana = student.getKana().split(" ");
		form.setLastKana(kana[0]);
		form.setFirstKana(kana[1]);
	}
}
