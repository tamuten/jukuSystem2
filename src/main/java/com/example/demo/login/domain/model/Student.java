package com.example.demo.login.domain.model;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;

@Data
public class Student {
	private String id;
	private String name;
	private String kana;
	private String gender;
	private Integer grade;
	private Date birthday;
	private String school;
	private String parentsName;
	private String phoneNumber;
	private String mailAddress;
	private String zipcode;
	private String address;
	private String course;
	private Timestamp registeredDatetime;
	private Timestamp updateDatetime;
}
