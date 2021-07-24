package com.example.demo.login.domain.model;

import java.util.Calendar;
import java.util.List;

import lombok.Data;

@Data
public class Tuesday {
	private Integer dayOfWeek = Calendar.TUESDAY;
	private List<Calendar> day;
}
