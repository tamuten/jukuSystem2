package com.example.demo.login.domain.model.dto;

import java.sql.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class SearchAttendDto {
	private Date searchDate;
	private Integer searchGrade;
	private String searchName;
}
