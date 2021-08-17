package com.example.demo.login.controller;

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
import com.example.demo.login.domain.repository.AttendLeaveDao;

@Controller
public class AttendController extends BaseController {
	@Autowired
	private AttendLeaveDao attendLeaveDao;
	@Autowired
	private AttendFormValidator validator;

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
		System.out.println(form.getStudentId());
		AttendLeave attendLeave = new AttendLeave();
		BeanUtils.copyProperties(form, attendLeave);
		attendLeaveDao.insert(attendLeave);

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
		attendLeaveDao.update(attendLeave);

		setMessage(model, Message.LEAVE);
		return "login/attend";
	}
}
