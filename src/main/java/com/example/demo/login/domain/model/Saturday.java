package com.example.demo.login.domain.model;

import java.util.Calendar;
import java.util.List;

import lombok.Data;

@Data
public class Saturday {
	private Integer dayOfWeek = Calendar.SATURDAY;
	private List<Calendar> day;

}
