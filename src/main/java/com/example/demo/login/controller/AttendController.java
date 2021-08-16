package com.example.demo.login.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.Message;

@Controller
public class AttendController extends BaseController {
	@GetMapping("/attend/index")
	public String index(Model model) {
		return "login/attend";
	}

	@PostMapping(value = "/attend", params = "attend")
	public String attend(Model model, HttpServletRequest request) {
		String studentId = request.getParameter("userId");
		System.out.println(studentId);
		setMessage(model, Message.ATTEND);
		return "login/attend";
	}

	@PostMapping(value = "/attend", params = "leave")
	public String leave(Model model, HttpServletRequest request) {
		String studentId = request.getParameter("userId");
		System.out.println(studentId);
		setMessage(model, Message.LEAVE);
		return "login/attend";
	}
}
