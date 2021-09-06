package com.example.demo.login.domain.model.dto;

import java.sql.Timestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class AttendListDto {
	private Integer id;
	private String studentId;
	private String studentName;
	private String grade;
	private Timestamp attendDatetime;
	private Timestamp leaveDatetime;
}
