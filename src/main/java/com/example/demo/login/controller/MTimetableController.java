package com.example.demo.login.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.login.domain.model.TimedBoolean;
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

	private Map<Integer, List<TimedBoolean>> createTimetable(){
		Map<Integer, List<TimedBoolean>> timetable = new LinkedHashMap<>();
		List<TimedBoolean> mon = new ArrayList<>();
		mon.add(new TimedBoolean("月", false));
		mon.add(new TimedBoolean("火", false));
		mon.add(new TimedBoolean("水", true));
		timetable.put(1, mon);

		List<TimedBoolean> tue = new ArrayList<>();
		tue.add(new TimedBoolean("月", false));
		tue.add(new TimedBoolean("火", false));
		tue.add(new TimedBoolean("水", true));
		timetable.put(2, tue);

		return timetable;
	}
}
