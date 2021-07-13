package com.example.demo.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.controller.form.TeacherForm;
import com.example.demo.login.controller.helper.TeacherHelper;
import com.example.demo.login.domain.model.Grade;
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

	@GetMapping("/teacher/signup")
	public String signup(@ModelAttribute TeacherForm form, Model model) {

		// コンボボックスの設定
		setCombobox(model);

		model.addAttribute("contents", "login/teacherSignup :: teacherSignup_contents");
		return "login/homeLayout";
	}

	@PostMapping("/teacher/register")
	public String register(@ModelAttribute @Validated TeacherForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			setCombobox(model);
			model.addAttribute("contents", "login/teacherSignup :: teacherSignup_contents");
			return "login/homeLayout";
		}
		Teacher teacher = TeacherHelper.convertFormToTeacher(form);
		teacher.setId(teacherService.getNextId());
		teacherService.insert(teacher);

		setCombobox(model);
		model.addAttribute("contents", "login/teacherDetail :: teacherDetail_contents");
		model.addAttribute("message", "登録が完了しました。");
		return "login/homeLayout";
	}

	private void setCombobox(Model model) {
		List<Grade> gradeList = comboboxService.findUnivGrade();
		model.addAttribute("gradeList", gradeList);
	}
}
