package com.example.demo.login.domain.model;

import java.sql.Date;

import lombok.Data;

@Data
public class ClassDetail {
	private Integer id;
	private Date date;
	private Integer timedId;
	private String student;
	private String subjectId;
	private String teacherId;
	private Boolean deleteFlg;
}
