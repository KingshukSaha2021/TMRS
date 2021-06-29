package com.persistent.hrms.tmrs.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.persistent.hrms.tmrs.mapper.TaskCommentMapper;
import com.persistent.hrms.tmrs.model.TaskComment;

@Repository
public class CommentServiceRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<TaskComment> getAllComments(long taskId, long userId){
		
		String sql = "Select TASK_ID, COMMENT, COMMENT_TIME, USER_ID from TASK_COMMENT where task_id = ? and user_id = ?";
		List<TaskComment> comments = new ArrayList<TaskComment>();
		
		comments = jdbcTemplate.query(sql, new Object[] {taskId, userId}, new TaskCommentMapper());
		
		return comments;
	}

}
