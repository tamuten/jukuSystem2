package com.example.demo.login.controller.form;

import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class StudentForm {
	private String id;
	@NotBlank
	@Size(max = 60)
	private String name;
	@NotNull
	private Integer grade;
	@Size(max = 60)
	private String school;
	@Size(max = 60)
	private String parentsName;
	@Size(max = 11)
	@Pattern(regexp = "^[0-9]*$")
	private String phoneNumber;
	@Email
	@Size(max = 60)
	private String mailAddress;
	@Size(max = 60)
	private String address;
	@NotBlank
	private String course;
	private Timestamp registeredDatetime;
	private Timestamp updateDatetime;
}
