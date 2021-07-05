package com.example.demo.login.controller;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

import com.example.demo.login.controller.form.StudentForm;
import com.example.demo.login.domain.model.Student;
import com.example.demo.login.domain.service.CourseService;
import com.example.demo.login.domain.service.LessonService;

@Controller
public class StudentController {
	final static Logger logger = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	private CourseService service;
	@Autowired
	private LessonService lessonService;

	@GetMapping("/studentList")
	public String index(Model model) {
		model.addAttribute("countents", "login/studentList :: studentList_contents");

		// 生徒一覧の取得
		// モデルに登録

		return "login/homeLayout";
	}

	/**
	 *	生徒情報新規登録画面を表示
	 *
	 * @param form
	 * @param model
	 * @return
	 */
	@GetMapping("/studentDetail/signup")
	public String signup(@ModelAttribute StudentForm form, Model model) {
		//		logger.debug("Course + signup");
		model.addAttribute("contents", "login/studentSignup :: studentSignup_contents");
		model.addAttribute("isNew", true);
		//		List<Lesson> lesson = lessonService.selectMany();
		//		model.addAttribute("lesson", lesson);
		return "login/homeLayout";
	}

	/**
	 * 生徒情報登録処理
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/student/register")
	public String register(@ModelAttribute @Validated StudentForm form, BindingResult result, Model model) {
		model.addAttribute("contents", "login/studentDetail :: studentDetail_contents");
		if (result.hasErrors()) {
			model.addAttribute("isNew", true);
			return "login/homeLayout";
		}
		Student course = new Student();
		BeanUtils.copyProperties(form, course);
		//		course.setId(service.getNextId());
		//		service.insertOne(course);

		BeanUtils.copyProperties(course, form);
		model.addAttribute("isNew", false);
		model.addAttribute("message", "登録が完了しました。");
		return "login/homeLayout";
	}

	/**
	 * 生徒情報詳細画面を表示
	 *
	 * @param form
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/studentDetail/{id:.+}")
	public String getUserDetail(@ModelAttribute StudentForm form, Model model, @PathVariable("id") String id) {
		//		logger.debug("Course + detail");
		//		logger.debug("courseId = " + id);
		model.addAttribute("contents", "login/studentDetail :: studentDetail_contents");
		model.addAttribute("isNew", false);

		if (StringUtils.isNotEmpty(id)) {
			//			Course course = service.selectOne(id);
			//			BeanUtils.copyProperties(course, form);
			//			model.addAttribute("signupForm", form);
		}
		//		List<Lesson> lesson = lessonService.selectMany();
		//		model.addAttribute("lesson", lesson);

		return "login/homeLayout";
	}

	@PostMapping("/student/update")
	public String update(@ModelAttribute @Validated StudentForm form, BindingResult result, Model model) {
		return "login/homeLayout";
	}
}
