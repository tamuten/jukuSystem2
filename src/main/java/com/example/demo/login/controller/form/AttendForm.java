package com.example.demo.login.controller.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class AttendForm {
	@NotBlank
	private String studentId;
}
