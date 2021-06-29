package com.persistent.hrms.tmrs.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.persistent.hrms.tmrs.model.Tasks;

@Repository
public class TaskServiceRepository{
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void updateTask(long taskId, int eta, String description, int priority) {
		String query = "Update TASKS set eta = ?, description = ?, priority = ? where id = ?";
		
		jdbcTemplate.update(query, eta, description, priority, taskId);
	}
	
	public void updateCompletionPercentage(int taskId, int complementionPercentage) {
		String sql = "Update TASKS set completion = ? where id = ?";
		
		jdbcTemplate.update(sql, complementionPercentage, taskId);
	}

}
