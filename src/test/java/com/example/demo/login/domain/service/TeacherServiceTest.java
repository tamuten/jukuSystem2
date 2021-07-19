package com.example.demo.login.domain.service;

import static org.junit.jupiter.api.Assertions.*;

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
	@DisplayName("講師IDが存在するとき、講師詳細を取得することを期待します")
	void whenTeacherIdExists_expectToGetUserDetails() {
		// データの準備
		Teacher teacher = new Teacher();
		teacher.setId("99999999");
		teacher.setName("原田 泰造");
		teacher.setKana("ハラダ タイゾウ");
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
		assertEquals(actualList, subjects);

	}

	// update
	// delete

}
