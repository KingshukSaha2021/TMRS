package com.persistent.hrms.tmrs.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.persistent.hrms.tmrs.model.TaskComment;

public class TaskCommentMapper implements RowMapper<TaskComment> {
	
	@Override
    public TaskComment mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		TaskComment comment = new TaskComment();
		comment.setTaskId(rs.getLong("TASK_ID"));
		comment.setComment(rs.getString("COMMENT"));
		comment.setCommentTime(rs.getDate("COMMENT_TIME"));
		comment.setUserId(rs.getLong("USER_ID"));
		
		return comment;
	}
}
