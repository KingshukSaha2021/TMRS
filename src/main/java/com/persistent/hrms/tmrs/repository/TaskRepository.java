package com.persistent.hrms.tmrs.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.persistent.hrms.tmrs.model.TaskComment;

@Repository
public class TaskRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void addComment(TaskComment comment) {
		
	}

}
