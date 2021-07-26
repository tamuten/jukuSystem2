package com.example.demo.login.domain.service;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.login.domain.model.Teacher;
import com.example.demo.login.domain.repository.TeacherDao;

@SpringBootTest
@Transactional
class TeacherServiceTest {
	@Autowired
	TeacherService service;
	@Autowired
	TeacherDao dao;

	@Test
	@DisplayName("代表値：講師IDが存在するとき、講師詳細を取得することを期待します")
	void whenTeacherIdExists_expectToGetUserDetails() {
		// 1.通常テスト データの準備
		Teacher teacher = new Teacher();
		teacher.setId("99999999");
		teacher.setName("原田 泰造");
		teacher.setKana("ハラダ タイゾウ");
		teacher.setGender("male");
		teacher.setBirthday(Date.valueOf("1993-03-10"));
		teacher.setUniversity("東北大学");
		teacher.setUndergraduate("経済学部");
		teacher.setDepartment("経済学科");
		teacher.setGrade(17);
		teacher.setPhoneNumber("08000000000");
		teacher.setMailAddress("taizou@sample.com");
		teacher.setZipcode("1500000");
		teacher.setAddress("東京都新宿区市谷田町3-1");
		teacher.setNote("笑顔がさわやかな好青年");
		teacher.setDeleteFlg(false);
		teacher.setRegisteredDatetime(new Timestamp(System.currentTimeMillis()));
		List<String> subjects = new ArrayList<>();
		subjects.add("0001");
		subjects.add("0002");
		teacher.setSubjects(subjects);
		service.insert(teacher);

		Teacher actual = service.selectOne("99999999");
		List<String> actualList = actual.getSubjects();

		assertEquals(teacher.getName(), actual.getName());
		assertEquals(teacher.getId(), actual.getId());
		assertEquals(teacher.getKana(), actual.getKana());
		assertEquals(teacher.getGender(), actual.getGender());
		assertEquals(teacher.getBirthday(), actual.getBirthday());
		assertEquals(teacher.getUniversity(), actual.getUniversity());
		assertEquals(teacher.getUndergraduate(), actual.getUndergraduate());
		assertEquals(teacher.getDepartment(), actual.getDepartment());
		assertEquals(teacher.getGrade(), actual.getGrade());
		assertEquals(teacher.getPhoneNumber(), actual.getPhoneNumber());
		assertEquals(teacher.getMailAddress(), actual.getMailAddress());
		assertEquals(teacher.getZipcode(), actual.getZipcode());
		assertEquals(teacher.getAddress(), actual.getAddress());
		assertEquals(teacher.getNote(), actual.getNote());
		assertEquals(teacher.getDeleteFlg(), actual.getDeleteFlg());
		assertEquals(teacher.getRegisteredDatetime(), actual.getRegisteredDatetime());
		assertEquals(actualList, subjects);

	}

	// update
	// delete

}
