package com.example.demo.login.controller.form;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class LessonForm {
	private String id;
	@Length(max = 60)
	private String name;
	@Length(max = 60)
	private String alias;
	private Integer time;
}