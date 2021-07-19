package com.example.demo.login.controller.form;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class TeacherForm {
	private String id;
	@NotBlank
	@Size(max = 30)
	private String lastName;
	@NotBlank
	@Size(max = 30)
	private String firstName;
	@NotBlank
	@Size(max = 30)
	@Pattern(regexp = "^[\\u30a0-\\u30ff]+$")
	private String lastKana;
	@NotBlank
	@Size(max = 30)
	@Pattern(regexp = "^[\\u30a0-\\u30ff]+$")
	private String firstKana;
	// 性別：初期値を不明に設定
	private String gender = "unknown";
	// String⇨dateに変換：patternにどのような形式で値が渡されるか指定している
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private Integer age;
	@Size(max = 60)
	private String university;
	@Size(max = 60)
	private String undergraduate;
	@Size(max = 60)
	private String department;
	private Integer grade;
	@Size(max = 12)
	@Pattern(regexp = "^[0-9]*$")
	private String phoneNumber;
	@Size(max = 60)
	@Email
	private String mailAddress;
	@Size(max = 7)
	@Pattern(regexp = "^[0-9]*$")
	private String zipcode;
	@Size(max = 60)
	private String address;
	@Size(max = 200)
	private String note;
	private Boolean deleteFlg;
	private Timestamp registeredDatetime;
	private Timestamp updateDatetime;
	private Timestamp deleteDatetime;
	// 指導可能教科
	@NotEmpty
//	private String[] subjectsCanTeach;
	private List<String> subjects;
}
