package com.example.demo.login.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.Message;
import com.example.demo.login.controller.form.StudentForm;
import com.example.demo.login.controller.helper.StudentHelper;
import com.example.demo.login.domain.model.Course;
import com.example.demo.login.domain.model.Grade;
import com.example.demo.login.domain.model.Student;
import com.example.demo.login.domain.model.Subject;
import com.example.demo.login.domain.model.Teacher;
import com.example.demo.login.domain.model.Timed;
import com.example.demo.login.domain.model.dto.StudentListDto;
import com.example.demo.login.domain.service.ComboboxService;
import com.example.demo.login.domain.service.CourseService;
import com.example.demo.login.domain.service.StudentService;
import com.example.demo.login.domain.service.TeacherService;

@Controller
public class StudentController extends BaseController {
	final static Logger logger = LoggerFactory.getLogger(CourseController.class);

	@Autowired
	private CourseService courseService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private ComboboxService comboboxService;
	@Autowired
	private TeacherService teacherService;

	/**
	 * 生徒一覧を取得する
	 *
	 * @param model
	 * @return
	 */
	@GetMapping("/studentList")
	public String index(Model model) {

		// 生徒一覧の取得
		List<StudentListDto> studentList = studentService.findAll();
		// モデルに登録
		model.addAttribute("studentList", studentList);
		return setView(model, "login/studentList");
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
		if (CollectionUtils.isEmpty(form.getClasses())) form.addClassesList();
		setCombobox(model);
		return setView(model, "login/studentSignup");
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
			if (CollectionUtils.isEmpty(form.getClasses())) form.addClassesList();
			setCombobox(model);
			return setView(model, "login/studentSignup");
		}
		Student student = StudentHelper.convertFormToStudent(form);
		student.setId(studentService.getNextId());
		studentService.insertOne(student);

		setMessage(model, Message.SIGNUP);
		return detail(form, model, student.getId());
	}

	/**
	 * コンボボックスをセットする
	 *
	 * @param model
	 */
	private void setCombobox(Model model) {
		List<Grade> gradeList = comboboxService.findStudentGrade();
		model.addAttribute("gradeList", gradeList);
		List<Course> courseList = courseService.selectMany();
		model.addAttribute("courseList", courseList);
		List<Subject> subjectList = comboboxService.findAllSubject();
		model.addAttribute("subjectList", subjectList);
		List<Timed> timedList = comboboxService.findAllTimed();
		model.addAttribute("timedList", timedList);
		List<Teacher> teacherList = teacherService.findAll();
		model.addAttribute("teacherList", teacherList);
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
	public String detail(@ModelAttribute StudentForm form, Model model, @PathVariable("id") String id) {

		if (StringUtils.isNotEmpty(id)) {
			Student student = studentService.selectOne(id);
			StudentHelper.convertStudentToForm(student, form);
		}

		if (CollectionUtils.isEmpty(form.getClasses())) form.addClassesList();
		setCombobox(model);
		return setView(model, "login/studentDetail");
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
		if (result.hasErrors()) {
			if (CollectionUtils.isEmpty(form.getClasses())) form.addClassesList();
			setCombobox(model);
			return setView(model, "login/studentDetail");
		}

		Student student = StudentHelper.convertFormToStudent(form);
		studentService.updateOne(student);

		setMessage(model, Message.UPDATE);
		return detail(form, model, student.getId());
	}

	/**
	 * 生徒情報を削除
	 *
	 * @param form
	 * @param model
	 * @return
	 */
	@PostMapping(value = "/studentDetail", params = "delete")
	public String delete(@ModelAttribute StudentForm form, Model model) {
		// delete
		studentService.deleteOne(form.getId());

		setMessage(model, Message.DELETE);
		return index(model);
	}

	@PostMapping(value = { "/studentDetail", "/student/register" }, params = "add")
	public String addList(@ModelAttribute StudentForm form, Model model, HttpServletRequest request) {
		form.addClassesList();

		setCombobox(model);
		String requestUri = request.getRequestURI();
		if (requestUri.equals("/student/register")) {
			return setView(model, "login/studentSignup");
		} else {
			return setView(model, "login/studentDetail");
		}

	}

	@PostMapping(value = { "/studentDetail", "/student/register" }, params = "remove")
	public String removeList(@ModelAttribute StudentForm form, Model model, HttpServletRequest request) {
		// 行削除の処理
		int index = Integer.valueOf(request.getParameter("remove"));
		form.removeClassesList(index);

		setCombobox(model);
		String requestUri = request.getRequestURI();
		if (requestUri.equals("/student/register")) {
			return setView(model, "login/studentSignup");
		} else {
			return setView(model, "login/studentDetail");
		}
	}

}
