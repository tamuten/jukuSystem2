package com.example.demo.login.controller;

import java.sql.Date;
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
import com.example.demo.login.controller.validator.AttendFormValidator;
import com.example.demo.login.domain.model.AttendLeave;
import com.example.demo.login.domain.model.dto.AttendListDto;
import com.example.demo.login.domain.repository.AttendLeaveDao;
import com.example.demo.login.domain.service.AttendLeaveService;

@Controller
public class AttendController extends BaseController {
	@Autowired
	private AttendLeaveDao attendLeaveDao;
	@Autowired
	private AttendFormValidator validator;
	@Autowired
	private AttendLeaveService attendLeaveService;

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
	public String getList(Model model) {
		Date today = new Date(System.currentTimeMillis());
		List<AttendListDto> attendList = attendLeaveDao.findAttendance(today);
		model.addAttribute("attendList", attendList);
		return setView(model, "login/attendList");
	}
}
