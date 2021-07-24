package com.example.demo.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.controller.form.ScheduleForm;
import com.example.demo.login.domain.service.ClassScheduleService;

@Controller
public class ScheduleController extends BaseController {
	@Autowired
	private ClassScheduleService classScheduleService;

	@GetMapping("/schedule/index")
	public String index(ScheduleForm form, Model model) {
		return setView(model, "login/createSchedule");
	}

	@PostMapping("/schedule/create")
	public String create(ScheduleForm form, Model model) {
		classScheduleService.createClassSchedule(form.getMonth());
		return setView(model, "login/createSchedule");
	}
}
