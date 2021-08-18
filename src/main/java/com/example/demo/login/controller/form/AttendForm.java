package com.example.demo.login.controller.form;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AttendForm extends BaseForm {
	@NotBlank
	private String studentId;
}
