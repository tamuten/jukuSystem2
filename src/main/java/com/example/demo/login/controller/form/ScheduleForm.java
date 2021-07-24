package com.example.demo.login.controller.form;

import java.time.YearMonth;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ScheduleForm {
	@DateTimeFormat(pattern = "yyyy-MM")
	private YearMonth month;
}
