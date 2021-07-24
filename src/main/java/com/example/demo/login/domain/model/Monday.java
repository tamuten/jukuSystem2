package com.example.demo.login.domain.model;

import java.util.Calendar;
import java.util.List;

import lombok.Data;

@Data
public class Monday {
	private Integer dayOfWeek = Calendar.MONDAY;
	private List<Calendar> day;
}
