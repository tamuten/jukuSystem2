package com.example.demo.login.domain.model;

import java.sql.Date;

import lombok.Data;

@Data
public class ClassSchedule {
	private String id;
	private String yearMonth;
	private Integer dayId;
	private Date date;
	private boolean deleteFlg;
}
