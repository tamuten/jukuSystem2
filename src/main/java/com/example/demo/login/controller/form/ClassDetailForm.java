package com.example.demo.login.controller.form;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class ClassDetailForm {
	private Integer id;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private LocalDate date;
	private Integer timedId;
	private String student;
	private String studentId;
	private String subjectId;
	private String teacherId;
	private String report;
	private Boolean deleteFlg;
}
