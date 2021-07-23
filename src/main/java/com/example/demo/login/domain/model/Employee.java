package com.example.demo.login.domain.model;

import java.sql.Date;

import lombok.Data;

@Data
public class Employee {
	private String id;
	private String name;
	private Date birthday;
	private String role;
	private String password;
}
