package com.example.demo.login.domain.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.login.domain.model.Lesson;
import com.example.demo.login.domain.repository.mybatis.LessonMapper;

/**
 * 授業DAOクラス
 *
 * @author takashi
 *
 */

@Repository
public class LessonDao {
	@Autowired
	private LessonMapper mapper;

	public void insertOne(Lesson lesson) {
		mapper.insert(lesson);
	}

	public List<Lesson> selectMany() {
		return mapper.selectMany();
	}
}
