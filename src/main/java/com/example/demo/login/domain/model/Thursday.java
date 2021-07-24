package com.example.demo.login.domain.model;

import java.util.Calendar;
import java.util.List;

import lombok.Data;

@Data
public class Thursday {
	private Integer dayOfWeek = Calendar.THURSDAY;
	private List<Calendar> day;
}
