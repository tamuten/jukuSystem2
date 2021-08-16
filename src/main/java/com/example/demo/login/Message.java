package com.example.demo.login;

public enum Message {
	SIGNUP("signup"), //
	UPDATE("update"), //
	DELETE("delete"), //
	ATTEND("attend"), //
	LEAVE("leave");//

	private Message(String key) {
		this.key = key;
	}

	private String key;

	public String getKey() {
		return this.key;
	}
}
