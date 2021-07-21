package com.example.demo.login.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.login.controller.form.EmployeeForm;
import com.example.demo.login.domain.model.Employee;
import com.example.demo.login.domain.repository.MEmployeeDao;

@Controller
public class MEmployeeController extends BaseController {
	@Autowired
	private MEmployeeDao dao;

	@GetMapping("/employeeDetail/{id:.+}")
	public String detail(@ModelAttribute EmployeeForm form, Model model, @PathVariable("id") String id) {

		if (StringUtils.isNotEmpty(id)) {
			Employee employee = dao.selectOne(id);
			BeanUtils.copyProperties(employee, form);
		}

		return setView(model, "login/employeeDetail");
	}
}
