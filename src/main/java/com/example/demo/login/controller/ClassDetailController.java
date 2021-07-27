package com.example.demo.login.controller;

import java.sql.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.login.controller.form.ClassDetailForm;
import com.example.demo.login.domain.model.ClassDetail;
import com.example.demo.login.domain.repository.ClassDetailDao;

@Controller
public class ClassDetailController extends BaseController {
	@Autowired
	private ClassDetailDao classDetailDao;

	@GetMapping("/classDetailList")
	public String index(Model model) {
		Date date = new Date(System.currentTimeMillis());
		model.addAttribute("classList", classDetailDao.findClass(date));
		return setView(model, "login/classDetailList");
	}

	@GetMapping("/classDetail/{id.+}")
	public String detail(ClassDetailForm form ,Model model, @PathVariable("id") Integer id) {
		ClassDetail classDetail = classDetailDao.selectOne(id);
		BeanUtils.copyProperties(classDetail, form);
		form.setDate(classDetail.getDate().toLocalDate());

		return setView(model, "login/classDetail");
	}
}
