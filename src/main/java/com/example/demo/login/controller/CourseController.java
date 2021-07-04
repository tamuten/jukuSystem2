package com.example.demo.login.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.controller.form.CourseForm;
import com.example.demo.login.domain.model.Course;
import com.example.demo.login.domain.service.CourseService;

@Controller
public class CourseController {
	@Autowired
	private CourseService service;

	/**
	 *	授業新規登録画面を表示
	 *
	 * @param form
	 * @param model
	 * @return
	 */
	@GetMapping("/courseDetail/new")
	public String index(@ModelAttribute CourseForm form, Model model) {
		model.addAttribute("contents", "login/courseDetail :: courseDetail_contents");
		model.addAttribute("isNew", true);
		return "login/homeLayout";
	}

	/**
	 * 授業登録処理
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/course/register")
	public String register(@ModelAttribute @Validated CourseForm form, BindingResult result, Model model) {
		model.addAttribute("contents", "login/courseDetail :: courseDetail_contents");
		if (result.hasErrors()) {
			model.addAttribute("isNew", true);
			return "login/homeLayout";
		}
		Course course = new Course();
		BeanUtils.copyProperties(form, course);
		course.setId(service.getNextId());
		service.insertOne(course);

		BeanUtils.copyProperties(course, form);
		model.addAttribute("isNew", false);
		model.addAttribute("message", "登録が完了しました。");
		return "login/homeLayout";
	}

	/**
	 * 授業詳細画面を表示
	 *
	 * @param form
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/courseDetail/{id:.+}")
	public String getUserDetail(@ModelAttribute CourseForm form, Model model, @PathVariable("id") String id) {
		System.out.println("courseId = " + id);
		model.addAttribute("contents", "login/courseDetail :: courseDetail_contents");
		model.addAttribute("isNew", false);

		if (StringUtils.isNotEmpty(id)) {
			Course course = service.selectOne(id);
			BeanUtils.copyProperties(course, form);
			model.addAttribute("signupForm", form);
		}

		return "login/homeLayout";
	}
}
