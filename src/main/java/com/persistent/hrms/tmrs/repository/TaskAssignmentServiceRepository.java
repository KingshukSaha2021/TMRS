package com.persistent.hrms.tmrs.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class TaskAssignmentServiceRepository {


	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void updateBlockReason(int taskId, String blockReason) {
		 String sql = "Update TASK_ASSIGNMENT set blocked = true, block_reason = ? where task_id = ?";
		 
		 jdbcTemplate.update(sql, blockReason, taskId);
	}
	
}
