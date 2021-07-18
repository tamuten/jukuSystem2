package com.example.demo.login.domain.model;

import lombok.Data;

@Data
public class Timetable {
	private String day;
	private Integer timedId;
	private Boolean isOpen;
}
