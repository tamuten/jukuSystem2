package com.example.demo.login.controller.form;

import java.util.List;

import com.example.demo.login.domain.model.Timed;

import lombok.Data;

@Data
public class TimedForm {
	private List<Timed> timedList;
}
