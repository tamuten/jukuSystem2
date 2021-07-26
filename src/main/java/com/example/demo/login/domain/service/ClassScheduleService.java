package com.example.demo.login.domain.service;

import java.sql.Date;
import java.time.YearMonth;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.ClassSchedule;
import com.example.demo.login.domain.repository.ClassDetailDao;
import com.example.demo.login.domain.repository.ClassScheduleDao;
import com.example.demo.login.exception.AlreadyClassScheduleRegisteredException;

@Service
public class ClassScheduleService {
	@Autowired
	private ClassScheduleDao classScheduleDao;
	@Autowired
	private ClassDetailDao classDetailDao;

	public void createClassSchedule(YearMonth yearMonth) {
		// 月のスケジュールが存在するか調べる
		// あれば以下の処理は行わない
		if (classScheduleDao.countRow(yearMonth.toString()) > 0) {
			throw new AlreadyClassScheduleRegisteredException("当該月分は既に実行済みです");
		}

		insertClassSchedule(yearMonth);
		classDetailDao.insert(yearMonth.toString());

	}

	private void insertClassSchedule(YearMonth yearMonth) {
		Calendar cal = Calendar.getInstance();
		for (int i = 1; i <= yearMonth.lengthOfMonth(); i++) {
			cal.set(yearMonth.getYear(), yearMonth.getMonthValue() - 1, i);

			ClassSchedule classSchedule = new ClassSchedule();
			classSchedule.setYearMonth(yearMonth.toString());
			classSchedule.setDayId(cal.get(Calendar.DAY_OF_WEEK));
			classSchedule.setDate(new Date(cal.getTime().getTime()));
			classScheduleDao.insert(classSchedule);
		}
	}

	public void deleteClassSchedule(YearMonth yearMonth) {
		classScheduleDao.delete(yearMonth.toString());
//		Date beginOfMonth = yearMonth.get

	}
}
