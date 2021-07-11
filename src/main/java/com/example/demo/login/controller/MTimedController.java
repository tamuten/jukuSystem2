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

import com.example.demo.login.controller.form.TimedForm;
import com.example.demo.login.domain.model.Timed;
import com.example.demo.login.domain.repository.MTimedDao;

@Controller
public class MTimedController extends BaseController {
	@Autowired
	private MTimedDao mTimedDao;

	@GetMapping("/timed")
	public String index(@ModelAttribute TimedForm form, Model model) {
		List<Timed> timedList = mTimedDao.findAll();
		model.addAttribute("timedList", timedList);
		model.addAttribute("contents", "login/timed :: timed_contents");
		return "login/homeLayout";
	}

	@PostMapping("/timed/update")
	public String update(@ModelAttribute @Validated TimedForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return index(form, model);
		}

		// update
		mTimedDao.update(form.getTimedList());

		model.addAttribute("message", "更新が完了しました。");
		return index(form, model);
	}
}
