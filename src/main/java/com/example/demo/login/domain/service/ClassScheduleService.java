package com.example.demo.login.domain.service;

import java.time.YearMonth;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.login.domain.model.Friday;
import com.example.demo.login.domain.model.Monday;
import com.example.demo.login.domain.model.Saturday;
import com.example.demo.login.domain.model.StudentClass;
import com.example.demo.login.domain.model.Sunday;
import com.example.demo.login.domain.model.Thursday;
import com.example.demo.login.domain.model.Tuesday;
import com.example.demo.login.domain.model.Wednesday;
import com.example.demo.login.domain.repository.StudentClassDao;

@Service
public class ClassScheduleService {
	@Autowired
	private StudentClassDao studentClassDao;

	public void createClassSchedule(YearMonth yearMonth) {
		int lengthOfMonth = yearMonth.lengthOfMonth();
		Calendar cal = Calendar.getInstance();

		Sunday sunday = new Sunday();
		Monday monday = new Monday();
		Tuesday tuesday = new Tuesday();
		Wednesday wednesday = new Wednesday();
		Thursday thursday = new Thursday();
		Friday friday = new Friday();
		Saturday saturday = new Saturday();

		for (int i = 1; i <= lengthOfMonth; i++) {
			cal.set(yearMonth.getYear(), yearMonth.getMonthValue() - 1, i);

			// 日付から曜日を取得する
			// Calendar.DAY_OF_WEEK:7 実際の値です（余り意味はない）
			switch (cal.get(Calendar.DAY_OF_WEEK)) {
			case Calendar.SUNDAY: // Calendar.SUNDAY:1 （値。意味はない）
				//日曜日
				sunday.getDays().add(cal);
				break;
			case Calendar.MONDAY: // Calendar.MONDAY:2
				//月曜日
				monday.getDay().add(cal);
				break;
			case Calendar.TUESDAY: // Calendar.TUESDAY:3
				//火曜日
				tuesday.getDay().add(cal);
				break;
			case Calendar.WEDNESDAY: // Calendar.WEDNESDAY:4
				//水曜日
				wednesday.getDay().add(cal);
				break;
			case Calendar.THURSDAY: // Calendar.THURSDAY:5
				//木曜日
				thursday.getDay().add(cal);
				break;
			case Calendar.FRIDAY: // Calendar.FRIDAY:6
				//金曜日
				friday.getDay().add(cal);
				break;
			case Calendar.SATURDAY: // Calendar.SATURDAY:7
				//土曜日
				saturday.getDay().add(cal);
				break;
			}
		}
		// 生徒授業リストを取得
		List<StudentClass> studentClassList = studentClassDao.findAll();

		// 授業リストごとに授業スケジュールを登録
	}
}
