package com.example.demo.login.controller.form;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class AttendListForm {
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate searchDate;
	private String searchName;
	private Integer searchGrade;
}
