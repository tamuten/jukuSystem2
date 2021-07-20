package com.example.demo.login.controller.form;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.example.demo.login.domain.model.StudentClass;

import lombok.Data;

@Data
public class StudentForm {
	private String id;
	@NotBlank
	@Size(max = 30)
	private String lastName;
	@NotBlank
	@Size(max = 30)
	private String firstName;
	@NotBlank
	@Size(max = 30)
	private String lastKana;
	@NotBlank
	@Size(max = 30)
	private String firstKana;
	private String gender = "unknown";
	@NotNull
	private Integer grade;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
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
	@Size(max = 7)
	@Pattern(regexp = "^[0-9]*$")
	private String zipcode;
	@Size(max = 60)
	private String address;
	@NotBlank
	private String course;
	private Timestamp registeredDatetime;
	private Timestamp updateDatetime;
	private Timestamp deleteDatetime;
	private Boolean deleteFlg;

	private List<StudentClass> classes;
}
