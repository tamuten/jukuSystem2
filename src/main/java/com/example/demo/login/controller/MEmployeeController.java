package com.example.demo.login.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.controller.form.EmployeeForm;
import com.example.demo.login.domain.model.Employee;
import com.example.demo.login.domain.repository.MEmployeeDao;

@Controller
public class MEmployeeController extends BaseController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private MEmployeeDao dao;

	@GetMapping("/employee/signup")
	public String signup(EmployeeForm form, Model model) {
		return setView(model, "login/employeeSignup");
	}

	@PostMapping("/employee/register")
	public String register(@Validated EmployeeForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return setView(model, "login/employeeSignup");
		}

		Employee employee = new Employee();
		BeanUtils.copyProperties(form, employee);
		String password = passwordEncoder.encode(form.getPassword());
		employee.setPassword(password);

		dao.insert(employee);

		return detail(form, model, employee.getId());
	}

	@GetMapping("/employeeDetail/{id:.+}")
	public String detail(@ModelAttribute EmployeeForm form, Model model, @PathVariable("id") String id) {

		if (StringUtils.isNotEmpty(id)) {
			Employee employee = dao.selectOne(id);
			BeanUtils.copyProperties(employee, form);
		}

		return setView(model, "login/employeeDetail");
	}
}
