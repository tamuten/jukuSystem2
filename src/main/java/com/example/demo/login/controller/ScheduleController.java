package com.example.demo.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.Message;
import com.example.demo.login.controller.form.ScheduleForm;
import com.example.demo.login.domain.service.ClassScheduleService;
import com.example.demo.login.exception.AlreadyClassScheduleRegisteredException;

@Controller
public class ScheduleController extends BaseController {
	@Autowired
	private ClassScheduleService classScheduleService;

	@GetMapping("/schedule/index")
	public String index(ScheduleForm form, Model model) {
		return setView(model, "login/createSchedule");
	}

	@PostMapping(value = "/schedule", params = "create")
	public String create(ScheduleForm form, Model model) {
		try {
			classScheduleService.createClassSchedule(form.getMonth());
		} catch (AlreadyClassScheduleRegisteredException e) {
			model.addAttribute("error", e.getMessage());
			return index(form, model);
		}
		setMessage(model, Message.SIGNUP);
		return index(form, model);
	}

	@PostMapping(value = "/schedule" , params = "delete")
	public String delete(ScheduleForm form, Model model) {
		classScheduleService.deleteClassSchedule(form.getMonth());
		setMessage(model, Message.DELETE);
		return index(form, model);
	}
}
