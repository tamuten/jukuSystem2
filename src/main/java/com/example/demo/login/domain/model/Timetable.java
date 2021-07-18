package com.example.demo.login.domain.model;

import lombok.Data;

@Data
public class Timetable {
	private Integer timedId;
	private boolean monday;
	private boolean tuesday;
	private boolean wednesday;
	private boolean thursday;
	private boolean friday;
	private boolean saturday;
	private boolean sunday;
}
