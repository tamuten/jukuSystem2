package com.example.demo.login.controller.form;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class BaseForm {
	private List<String> errors;

	public BaseForm() {
		this.errors = new ArrayList<>();
	}

	public void addError(String message) {
		errors.add(message);
	}

	public boolean hasErrors() {
		return errors.size() > 0;
	}
}
