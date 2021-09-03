package com.example.demo.login.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.login.controller.form.ClassDetailForm;
import com.example.demo.login.controller.form.ClassDetailListForm;
import com.example.demo.login.domain.model.ClassDetail;
import com.example.demo.login.domain.model.Grade;
import com.example.demo.login.domain.model.Subject;
import com.example.demo.login.domain.model.Teacher;
import com.example.demo.login.domain.model.Timed;
import com.example.demo.login.domain.repository.ClassDetailDao;
import com.example.demo.login.domain.service.ComboboxService;
import com.example.demo.login.domain.service.TeacherService;

@Controller
public class ClassDetailController extends BaseController {
	@Autowired
	private ClassDetailDao classDetailDao;
	@Autowired
	private ComboboxService comboboxService;
	@Autowired
	private TeacherService teacherService;

	@GetMapping("/classDetailList")
	public String index(ClassDetailListForm form, Model model) {
		if (form.getDate() == null) {
			form.setDate(LocalDate.now());
		}
		Date searchDate = Date.valueOf(form.getDate());
		model.addAttribute("classList", classDetailDao.findClass(searchDate));
		return setView(model, "login/classDetailList");
	}

	@GetMapping("/classDetailList/search")
	public String search(ClassDetailListForm form, Model model) {
		if (form.getDate() == null) {
			form.setDate(LocalDate.now());
		}
		Date searchDate = Date.valueOf(form.getDate());
		model.addAttribute("classList", classDetailDao.findClass(searchDate));
		return setView(model, "login/classDetailList");
	}

	@GetMapping("/classDetail/{id:.+}")
	public String detail(ClassDetailForm form, Model model, @PathVariable("id") Integer id) {
		ClassDetail classDetail = classDetailDao.selectOne(id);
		BeanUtils.copyProperties(classDetail, form);
		form.setDate(classDetail.getDate()
			.toLocalDate());
		setCombobox(model);
		return setView(model, "login/classDetail");
	}

	private void setCombobox(Model model) {
		List<Grade> gradeList = comboboxService.findStudentGrade();
		model.addAttribute("gradeList", gradeList);
		List<Subject> subjectList = comboboxService.findAllSubject();
		model.addAttribute("subjectList", subjectList);
		List<Timed> timedList = comboboxService.findAllTimed();
		model.addAttribute("timedList", timedList);
		List<Teacher> teacherList = teacherService.findAll();
		model.addAttribute("teacherList", teacherList);
	}
}
