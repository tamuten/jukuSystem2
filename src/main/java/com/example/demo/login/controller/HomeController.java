package com.example.demo.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.Course;
import com.example.demo.login.domain.model.Lesson;
import com.example.demo.login.domain.service.CourseService;
import com.example.demo.login.domain.service.LessonService;

@Controller
public class HomeController {

	@Autowired
	LessonService lessonService;
	@Autowired
	CourseService courseService;

	//ユーザー一覧画面のGET用メソッド.
	@GetMapping("/home")
	public String getHome(Model model) {

		//コンテンツ部分にユーザー詳細を表示するための文字列を登録
		model.addAttribute("contents", "login/home :: home_contents");

		return "login/homeLayout";
	}

	//ログアウト用メソッド.
	@PostMapping("/logout")
	public String postLogout() {

		//ログイン画面にリダイレクト
		return "redirect:/login";
	}

	/**
	 * 授業一覧画面の表示
	 *
	 * @param model
	 * @return
	 */
	@GetMapping("/lessonList")
	public String getLessonList(Model model) {
		model.addAttribute("contents", "login/lessonList :: lessonList_contents");

		//授業一覧の取得
		List<Lesson> lessonList = lessonService.selectMany();
		model.addAttribute("lessonList", lessonList);

		return "login/homeLayout";
	}

	/**
	 * コース一覧の表示
	 *
	 * @param model
	 * @return
	 */
	@GetMapping("/courseList")
	public String getCourseList(Model model) {
		model.addAttribute("contents", "login/courseList :: courseList_contents");

		List<Course> courseList = courseService.selectMany();
		model.addAttribute("courseList", courseList);

		return "login/homeLayout";
	}

	// 生徒一覧の表示
	//	@GetMapping("/studentList")
	//	public String getStudentList(Model model) {
	//		model.addAttribute("contents", "login/studentList :: studentList_contents");
	//
	//		// 生徒情報取得
	//		// モデルに登録
	//
	//		return "login/homeLayout";
	//	}
}