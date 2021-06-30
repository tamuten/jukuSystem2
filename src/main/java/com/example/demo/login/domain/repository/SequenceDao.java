package com.example.demo.login.domain.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.login.Sequence;

@Repository
public class SequenceDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int getSequence(Sequence sequece) {
		String key = sequece.getKey();
		String sql = "SELECT nextval('" + key + "') ";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
}
