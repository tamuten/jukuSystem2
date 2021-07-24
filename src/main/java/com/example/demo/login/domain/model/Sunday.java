package com.example.demo.login.domain.model;

import java.util.Calendar;
import java.util.List;

import lombok.Data;

@Data
public class Sunday {
	private Integer dayOfWeek = Calendar.SUNDAY;
	private List<Calendar> days;
}
