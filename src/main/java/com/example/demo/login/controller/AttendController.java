package com.example.demo.login.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.Message;
import com.example.demo.login.controller.form.AttendForm;
import com.example.demo.login.controller.form.AttendListForm;
import com.example.demo.login.controller.validator.AttendFormValidator;
import com.example.demo.login.domain.model.AttendLeave;
import com.example.demo.login.domain.model.Grade;
import com.example.demo.login.domain.model.dto.AttendListDto;
import com.example.demo.login.domain.repository.AttendLeaveDao;
import com.example.demo.login.domain.repository.GradeDao;
import com.example.demo.login.domain.service.AttendLeaveService;

@Controller
public class AttendController extends BaseController {
	@Autowired
	private AttendLeaveDao attendLeaveDao;
	@Autowired
	private AttendFormValidator validator;
	@Autowired
	private AttendLeaveService attendLeaveService;
	@Autowired
	private GradeDao gradeDao;

	@InitBinder("attendForm")
	public void validatorBinder(WebDataBinder binder) {
		binder.addValidators(validator);
	}

	@GetMapping("/attend/index")
	public String index(AttendForm form, Model model) {
		return "login/attend";
	}

	@PostMapping(value = "/attend", params = "attend")
	public String attend(@Validated AttendForm form, BindingResult result, Model model, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "login/attend";
		}
		attendLeaveService.formCheckBeforeAttend(form);
		if (form.hasErrors()) {
			return "login/attend";
		}
		System.out.println(form.getStudentId());
		AttendLeave attendLeave = new AttendLeave();
		BeanUtils.copyProperties(form, attendLeave);

		attendLeaveService.attend(attendLeave);

		setMessage(model, Message.ATTEND);
		return "login/attend";
	}

	@PostMapping(value = "/attend", params = "leave")
	public String leave(@Validated AttendForm form, BindingResult result, Model model, HttpServletRequest request) {
		if (result.hasErrors()) {
			return "login/attend";
		}
		System.out.println(form.getStudentId());
		AttendLeave attendLeave = new AttendLeave();
		BeanUtils.copyProperties(form, attendLeave);
		attendLeaveService.leave(attendLeave);

		setMessage(model, Message.LEAVE);
		return "login/attend";
	}

	@GetMapping("/attendList")
	public String getList(AttendListForm form, Model model) {
		if (form.getSearchDate() == null) {
			form.setSearchDate(LocalDate.now());
		}
		Date today = Date.valueOf(form.getSearchDate());
		List<AttendListDto> attendList = attendLeaveDao.findAttendance(today);
		model.addAttribute("attendList", attendList);
		setSearchCombobox(model);
		return setView(model, "login/attendList");
	}

	@GetMapping("/attendList/search")
	public String search(AttendListForm form, Model model) {
		return setView(model, "login/attendList");
	}

	private void setSearchCombobox(Model model) {
		List<Grade> gradeList = gradeDao.findStudentGrade();
		model.addAttribute("gradeList", gradeList);
	}
}
