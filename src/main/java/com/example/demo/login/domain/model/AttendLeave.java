package com.example.demo.login.domain.model;

import java.sql.Date;
import java.sql.Timestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class AttendLeave {
	private Integer id;
	private String studentId;
	private Date date;
	private Timestamp attendDatetime;
	private Timestamp leaveDatetime;
}
