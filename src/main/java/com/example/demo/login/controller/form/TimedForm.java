package com.example.demo.login.controller.form;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.login.domain.model.Timed;

import lombok.Data;

@Data
public class TimedForm {
	@Valid
	private List<Timed> timedList;
}
