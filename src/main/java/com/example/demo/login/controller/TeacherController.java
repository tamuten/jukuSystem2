package com.example.demo.login.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.Message;
import com.example.demo.login.controller.form.TeacherForm;
import com.example.demo.login.controller.helper.TeacherHelper;
import com.example.demo.login.domain.model.Grade;
import com.example.demo.login.domain.model.Subject;
import com.example.demo.login.domain.model.Teacher;
import com.example.demo.login.domain.service.ComboboxService;
import com.example.demo.login.domain.service.TeacherService;

@Controller
public class TeacherController extends BaseController {
	@Autowired
	private TeacherService teacherService;
	@Autowired
	private ComboboxService comboboxService;

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

		return setView(model, "login/teacherList");
	}

	/**
	 * 講師新規登録画面を表示
	 *
	 * @param form
	 * @param model
	 * @return
	 */
	@GetMapping("/teacher/signup")
	public String signup(@ModelAttribute TeacherForm form, Model model) {

		// コンボボックスの設定
		setCombobox(model);
		return setView(model, "login/teacherSignup");
	}

	/**
	 * 講師登録処理
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/teacher/register")
	public String register(@ModelAttribute @Validated TeacherForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			setCombobox(model);
			return setView(model, "login/teacherSignup");
		}
		Teacher teacher = TeacherHelper.convertFormToTeacher(form);
		teacher.setId(teacherService.getNextId());
		teacherService.insert(teacher);

		setCombobox(model);
		setMessage(model, Message.SIGNUP);
		return setView(model, "login/teacherDetail");
	}

	/**
	 * 講師詳細画面を表示
	 *
	 * @param form
	 * @param model
	 * @param id
	 * @return
	 */
	@GetMapping("/teacherDetail/{id:.+}")
	public String getUserDetail(@ModelAttribute TeacherForm form, Model model, @PathVariable("id") String id) {

		if (StringUtils.isNotEmpty(id)) {
			Teacher teacher = teacherService.selectOne(id);
			TeacherHelper.convertTeacherToForm(teacher, form);
		}

		setCombobox(model);
		return setView(model, "login/teacherDetail");
	}

	@PostMapping(value="/teacherDetail", params = "update")
	public String update(@ModelAttribute @Validated TeacherForm form, BindingResult result, Model model) {
		if(result.hasErrors()) {
			setCombobox(model);
			return setView(model, "login/teacherDetail");
		}

		Teacher teacher = TeacherHelper.convertFormToTeacher(form);
		teacherService.updateOne(teacher);

		setCombobox(model);
		setMessage(model, Message.SIGNUP);
		return setView(model, "login/teacherDetail");
	}


	/**
	 * コンボボックスをセットする
	 *
	 * @param model
	 */
	private void setCombobox(Model model) {
		List<Grade> gradeList = comboboxService.findUnivGrade();
		model.addAttribute("gradeList", gradeList);
		List<Subject> subjectList = comboboxService.findAllSubject();
		model.addAttribute("subjectList", subjectList);
	}
}
