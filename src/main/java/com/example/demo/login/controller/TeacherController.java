package com.example.demo.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.login.domain.model.Teacher;
import com.example.demo.login.domain.service.TeacherService;

@Controller
public class TeacherController extends BaseController {
	@Autowired
	private TeacherService teacherService;

	/**
	 * 講師一覧を表示
	 *
	 * @param model
	 * @return
	 */
	@GetMapping("/teacherList")
	public String index(Model model) {

		List<Teacher> teacherList = teacherService.findAll();
		model.addAttribute("teacherList", teacherList);

		model.addAttribute("contents", "login/teacherList :: teacherList_contents");
		return "login/homeLayout";
	}
}
