package com.example.demo.login.domain.model;

import java.time.LocalTime;

import lombok.Data;

@Data
public class Timed {
	private Integer id;
	private String name;
	private LocalTime startTime;
	private LocalTime endTime;
	private Boolean useFlag;
}
