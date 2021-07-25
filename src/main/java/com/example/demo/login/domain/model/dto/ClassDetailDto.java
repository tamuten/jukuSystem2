package com.example.demo.login.domain.model.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class ClassDetailDto {
	private Integer id;
	private Date date;
	private Integer timedId;
	private String studentGrade;
	private String studentName;
	private String subjectName;
	private String teacherName;
}
