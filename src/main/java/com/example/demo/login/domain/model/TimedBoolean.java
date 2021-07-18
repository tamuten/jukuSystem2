package com.example.demo.login.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TimedBoolean {
	private String day;
	private Boolean isOpen;
}
