package com.example.demo.login.domain.model;

import java.sql.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class ClassDetail {
	private Integer id;
	private Date date;
	private Integer timedId;
	private String student;
	private String subjectId;
	private String teacherId;
	private String report;
	private Boolean deleteFlg;
}
