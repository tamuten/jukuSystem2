package com.example.demo.login.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.login.domain.model.Timetable;
import com.example.demo.login.domain.repository.MTimetableDao;

@Service
@Transactional
public class MTimetableService {
	@Autowired
	private MTimetableDao mTimetableDao;

	public List<Timetable> findAll() {
		return mTimetableDao.findAll();
	}

	public void update(List<Timetable> timetables) {
		for (Timetable timetable : timetables)
			mTimetableDao.update(timetable);

	}
}
