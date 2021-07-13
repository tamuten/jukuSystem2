package com.example.demo.login.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

@Controller
public class BaseController {
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// 未入力のStringをnullに設定する
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	protected String setView(Model model, String contentPath) {
		String contentName = contentPath.substring(contentPath.lastIndexOf("/") + 1);
		model.addAttribute("contents", contentPath + " :: " + contentName + "_contents");
		return "login/homeLayout";
	}
}
