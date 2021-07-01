package com.example.demo.login.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.login.Sequence;
import com.example.demo.login.domain.model.Lesson;
import com.example.demo.login.domain.repository.LessonDao;
import com.example.demo.login.domain.repository.SequenceDao;

@Service
@Transactional
public class LessonService {
	@Autowired
	private LessonDao lessonDao;
	@Autowired
	private SequenceDao sequenceDao;

	public String getNextId() {
		int nextId = sequenceDao.getSequence(Sequence.LESSON);
		// 8桁ゼロ埋めして返却
		return String.format("%08d", nextId);
	}

	public void insertOne(Lesson lesson) {
		lessonDao.insertOne(lesson);
	}

	public List<Lesson> selectMany() {
		return lessonDao.selectMany();
	}

	public Lesson selectOne(String lessonId) {

		return lessonDao.selectOne(lessonId);
	}
}
