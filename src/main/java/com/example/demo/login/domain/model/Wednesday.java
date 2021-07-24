package com.example.demo.login.domain.model;

import java.util.Calendar;
import java.util.List;

import lombok.Data;

@Data
public class Wednesday {
	private Integer dayOfWeek = Calendar.WEDNESDAY;
	private List<Calendar> day;
}
