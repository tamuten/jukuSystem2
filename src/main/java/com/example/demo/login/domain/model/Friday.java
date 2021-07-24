package com.example.demo.login.domain.model;

import java.util.Calendar;
import java.util.List;

import lombok.Data;

@Data
public class Friday {
	private Integer dayOfWeek = Calendar.FRIDAY;
	private List<Calendar> day;
}
