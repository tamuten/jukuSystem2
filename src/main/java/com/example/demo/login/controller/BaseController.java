package com.example.demo.login.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.example.demo.login.Message;

@Controller
public class BaseController {
	@Autowired
	MessageSource messageSource;

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

	protected void setMessage(Model model, Message message) {
		model.addAttribute("message", messageSource.getMessage(message.getKey(), null, Locale.JAPAN));
	}
}
