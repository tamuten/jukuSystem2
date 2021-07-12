package com.example.demo.login.controller.form;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.example.demo.login.domain.model.Subject;

import lombok.Data;

@Data
public class TeacherForm {
	private String id;
	private String name;
	private String lastName;
	private String firstName;
	private String kana;
	private String lastKana;
	private String firstKana;
	private String gender;
	private Date birthday;
	private Integer age;
	private String university;
	private String undergraduate;
	private String department;
	private Integer grade;
	private String phoneNumber;
	private String mailAddress;
	private String zipcode;
	private String address;
	private String note;
	private Boolean deleteFlg;
	private Timestamp registeredDatetime;
	private Timestamp updateDatetime;
	private Timestamp deleteDatetime;
	// 指導可能教科
	private List<Subject> subjectsCanTeach;
}
