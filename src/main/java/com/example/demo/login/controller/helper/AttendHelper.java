package com.example.demo.login.controller.helper;

import java.sql.Date;

import org.springframework.beans.BeanUtils;

import com.example.demo.login.controller.form.AttendListForm;
import com.example.demo.login.domain.model.dto.SearchAttendDto;

public class AttendHelper {
	public static SearchAttendDto formToDto(AttendListForm form) {
		SearchAttendDto searchAttendDto = new SearchAttendDto();
		BeanUtils.copyProperties(form, searchAttendDto);
		searchAttendDto.setSearchDate(Date.valueOf(form.getSearchDate()));
		return searchAttendDto;
	}
}
