package com.example.demo.login.domain.service;

import java.sql.Date;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.ClassSchedule;
import com.example.demo.login.domain.model.StudentClass;
import com.example.demo.login.domain.repository.ClassScheduleDao;
import com.example.demo.login.domain.repository.StudentClassDao;

@Service
public class ClassScheduleService {
	@Autowired
	private StudentClassDao studentClassDao;
	@Autowired
	private ClassScheduleDao classScheduleDao;

	public void createClassSchedule(YearMonth yearMonth) {
		int lengthOfMonth = yearMonth.lengthOfMonth();
		Calendar cal = Calendar.getInstance();

		for (int i = 1; i <= lengthOfMonth; i++) {
			cal.set(yearMonth.getYear(), yearMonth.getMonthValue() - 1, i);

			ClassSchedule classSchedule = new ClassSchedule();
			classSchedule.setYearMonth(yearMonth.toString());
			classSchedule.setDayId(cal.get(Calendar.DAY_OF_WEEK));
			classSchedule.setDate(new Date(cal.getTime().getTime()));
			classScheduleDao.insert(classSchedule);
		}
		// 生徒授業リストを取得
		List<StudentClass> studentClassList = studentClassDao.findAll();

		// 授業リストごとに授業スケジュールを登録
	}
}
