package com.example.demo.login.controller;

import java.util.List;

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
import com.example.demo.login.domain.model.Course;
import com.example.demo.login.domain.model.Grade;
import com.example.demo.login.domain.model.Student;
import com.example.demo.login.domain.model.dto.StudentListDto;
import com.example.demo.login.domain.service.ComboboxService;
import com.example.demo.login.domain.service.CourseService;
import com.example.demo.login.domain.service.StudentService;

@Controller
public class StudentController {
	final static Logger logger = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private ComboboxService comboboxService;

	@GetMapping("/studentList")
	public String index(Model model) {
		model.addAttribute("contents", "login/studentList :: studentList_contents");

		// 生徒一覧の取得
		List<StudentListDto> studentList = studentService.findAll();
		// モデルに登録
		model.addAttribute("studentList", studentList);

		return "login/homeLayout";
	}

	/**
	 *	生徒情報新規登録画面を表示
	 *
	 * @param form
	 * @param model
	 * @return
	 */
	@GetMapping("/student/signup")
	public String signup(@ModelAttribute StudentForm form, Model model) {
		//		logger.debug("Course + signup");
		model.addAttribute("contents", "login/studentSignup :: studentSignup_contents");
		List<Grade> gradeList = comboboxService.findGrade();
		model.addAttribute("gradeList", gradeList);
		List<Course> courseList = courseService.selectMany();
		model.addAttribute("courseList", courseList);

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

		if (result.hasErrors()) {
			//			model.addAttribute("isNew", true);
			List<Grade> gradeList = comboboxService.findGrade();
			model.addAttribute("gradeList", gradeList);
			List<Course> courseList = courseService.selectMany();
			model.addAttribute("courseList", courseList);
			model.addAttribute("contents", "login/studentSignup :: studentSignup_contents");
			return "login/homeLayout";
		}
		Student student = new Student();
		BeanUtils.copyProperties(form, student);
		//		course.setId(service.getNextId());
		student.setId(studentService.getNextId());
		//		service.insertOne(course);
		studentService.insertOne(student);

		BeanUtils.copyProperties(student, form);
		//		model.addAttribute("isNew", false);

		List<Grade> gradeList = comboboxService.findGrade();
		model.addAttribute("gradeList", gradeList);
		List<Course> courseList = courseService.selectMany();
		model.addAttribute("courseList", courseList);
		model.addAttribute("contents", "login/studentDetail :: studentDetail_contents");
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
		//		model.addAttribute("isNew", false);

		if (StringUtils.isNotEmpty(id)) {
			Student student = studentService.selectOne(id);
			BeanUtils.copyProperties(student, form);
		}

		List<Grade> gradeList = comboboxService.findGrade();
		model.addAttribute("gradeList", gradeList);
		List<Course> courseList = courseService.selectMany();
		model.addAttribute("courseList", courseList);
		return "login/homeLayout";
	}

	/**
	 * 生徒情報を更新
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/studentDetail", params = "update")
	public String update(@ModelAttribute @Validated StudentForm form, BindingResult result, Model model) {
		model.addAttribute("contents", "login/studentDetail :: studentDetail_contents");
		if (result.hasErrors()) {
			List<Grade> gradeList = comboboxService.findGrade();
			model.addAttribute("gradeList", gradeList);
			List<Course> courseList = courseService.selectMany();
			model.addAttribute("courseList", courseList);
			return "login/homeLayout";
		}

		Student student = new Student();
		BeanUtils.copyProperties(form, student);

		// update
		studentService.updateOne(student);

		List<Grade> gradeList = comboboxService.findGrade();
		model.addAttribute("gradeList", gradeList);
		List<Course> courseList = courseService.selectMany();
		model.addAttribute("courseList", courseList);
		model.addAttribute("message", "更新が完了しました。");
		return "login/homeLayout";
	}

	/**
	 * 生徒情報を削除
	 *
	 * @param form
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/student", params = "delete")
	public String delete(@ModelAttribute StudentForm form, Model model) {
		model.addAttribute("contents", "login/studentList :: studentList_contents");
		// delete
		studentService.deleteOne(form.getId());

		model.addAttribute("message", "削除が完了しました。");
		return "login/homeLayout";
	}
}
