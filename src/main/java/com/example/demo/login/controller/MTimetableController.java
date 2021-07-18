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

import com.example.demo.login.controller.form.TimetableForm;
import com.example.demo.login.domain.model.Timetable;
import com.example.demo.login.domain.service.MTimetableService;

@Controller
public class MTimetableController extends BaseController {
	@Autowired
	private MTimetableService service;

	@GetMapping("/timetable")
	public String index(Model model) {
		List<Timetable> timetable = service.findAll();
		model.addAttribute("timetable", timetable);
		return setView(model, "login/timetable");
	}

	//	private Map<Integer, List<TimedBoolean>> createTimetable(){
	//		Map<Integer, List<TimedBoolean>> timetable = new LinkedHashMap<>();
	//		List<TimedBoolean> mon = new ArrayList<>();
	//		mon.add(new TimedBoolean("月", false));
	//		mon.add(new TimedBoolean("火", false));
	//		mon.add(new TimedBoolean("水", true));
	//		timetable.put(1, mon);
	//
	//		List<TimedBoolean> tue = new ArrayList<>();
	//		tue.add(new TimedBoolean("月", false));
	//		tue.add(new TimedBoolean("火", false));
	//		tue.add(new TimedBoolean("水", true));
	//		timetable.put(2, tue);
	//
	//		return timetable;
	//	}

	@PostMapping("/timetable/update")
	public String update(@ModelAttribute @Validated TimetableForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return index(model);
		}
		service.update(form.getTimetable());

		return index(model);
	}

}
