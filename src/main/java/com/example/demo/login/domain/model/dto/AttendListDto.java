package com.example.demo.login.domain.model.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class AttendListDto {
	private Integer id;
	private String studentId;
	private String studentName;
	private String grade;
	private Timestamp attendDatetime;
	private Timestamp leaveDatetime;
}
