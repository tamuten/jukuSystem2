package com.example.demo.login;

public enum Sequence {

	LESSON("lesson_id_seq");

	private Sequence(String key) {
		this.key = key;
	}

	private String key;

	public String getKey() {
		return this.key;
	}

}
