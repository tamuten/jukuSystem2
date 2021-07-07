package com.example.demo.login.domain.model.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class StudentListDto {
	private String id;
	private String name;
	private String grade;
	private String school;
	private String parentsName;
	private String phoneNumber;
	private String mailAddress;
	private String address;
	private String course;
	private Timestamp registeredDatetime;
}
