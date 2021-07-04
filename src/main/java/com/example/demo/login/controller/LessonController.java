package com.example.demo.login.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.controller.form.LessonForm;
import com.example.demo.login.domain.model.Lesson;
import com.example.demo.login.domain.service.LessonService;

@Controller
public class LessonController {
	@Autowired
	private LessonService service;

	/**
	 *	授業新規登録画面を表示
	 *
	 * @param form
	 * @param model
	 * @return
	 */
	@GetMapping("/lessonDetail/new")
	public String index(@ModelAttribute LessonForm form, Model model) {
		model.addAttribute("contents", "login/lessonDetail :: lessonDetail_contents");
		model.addAttribute("isNew", true);
		return "login/homeLayout";
	}

	/**
	 * 授業登録処理
	 *
	 * @param form
	 * @param result
	 * @param model
	 * @return
	 */
	@PostMapping("/lesson/register")
	public String register(@ModelAttribute @Validated LessonForm form, BindingResult result, Model model) {
		model.addAttribute("contents", "login/lessonDetail :: lessonDetail_contents");
		if (result.hasErrors()) {
			model.addAttribute("isNew", true);
			return "login/homeLayout";
		}
		Lesson lesson = new Lesson();
		BeanUtils.copyProperties(form, lesson);
		lesson.setId(service.getNextId());
		service.insertOne(lesson);

		BeanUtils.copyProperties(lesson, form);
		model.addAttribute("isNew", false);
		model.addAttribute("message", "登録が完了しました。");
		return "login/homeLayout";
	}

	/**
	 * 授業詳細画面を表示
	 *
	 * @param form
	 * @param model
	 * @param lessonId
	 * @return
	 */
	@GetMapping("/lessonDetail/{id:.+}")
	public String getUserDetail(@ModelAttribute LessonForm form, Model model, @PathVariable("id") String lessonId) {
		System.out.println("lessonId = " + lessonId);
		model.addAttribute("contents", "login/lessonDetail :: lessonDetail_contents");
		model.addAttribute("isNew", false);

		if (StringUtils.isNotEmpty(lessonId)) {
			Lesson lesson = service.selectOne(lessonId);
			BeanUtils.copyProperties(lesson, form);
			model.addAttribute("signupForm", form);
		}

		return "login/homeLayout";
	}

	@PostMapping("/lesson/update")
	public String updateOne(@ModelAttribute @Validated LessonForm form, BindingResult result, Model model) {
		model.addAttribute("contents", "login/lessonDetail :: lessonDetail_contents");
		model.addAttribute("isNew", false);
		if (result.hasErrors()) {
			return "login/homeLayout";
		}
		Lesson lesson = new Lesson();
		BeanUtils.copyProperties(form, lesson);
		service.updateOne(lesson);

		BeanUtils.copyProperties(lesson, form);
		model.addAttribute("message", "更新が完了しました。");
		return "login/homeLayout";
	}

	@PostMapping("/lesson/delete")
	public String deleteOne(@ModelAttribute LessonForm form, Model model) {
		model.addAttribute("contents", "login/lessonList :: lessonList_contents");
		String id = form.getId();
		service.deleteOne(id);

		model.addAttribute("message", "削除が完了しました。");
		return "login/homeLayout";
	}

}
