package com.example.demo.login.controller.form;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class StudentForm {
	private String id;
	private String name;
	private Integer grade;
	private String school;
	private String parentsName;
	private String phoneNumber;
	private String mailAddress;
	private String address;
	private String course;
	private Timestamp registeredDatetime;
	private Timestamp updateDatetime;
}
