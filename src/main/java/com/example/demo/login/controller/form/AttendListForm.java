package com.example.demo.login.controller.form;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class AttendListForm {
	private LocalDate searchDate;
	private String searchName;
	private Integer searchGrade;
}
