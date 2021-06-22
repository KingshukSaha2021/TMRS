package com.persistent.hrms.tmrs.mapper;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.persistent.hrms.tmrs.model.AllTaskModel;

public class AllTaskRowMapper implements RowMapper<AllTaskModel> {
	
	@Override
    public AllTaskModel mapRow(ResultSet rs, int rowNum) throws SQLException {

		AllTaskModel allTask = new AllTaskModel();
		allTask.setId(rs.getInt("ID"));
		allTask.setTaskType(rs.getString("TASK_TYPE"));
		allTask.setPriority(rs.getInt("PRIORITY"));
		allTask.setTaskName(rs.getString("NAME"));
		allTask.setTaskDescription(rs.getString("DESCRIPTION"));
		allTask.setCompletionPercentage(rs.getInt("COMPLETION"));
		allTask.setEta(rs.getInt("ETA"));
		allTask.setAssignmentDate(rs.getDate("ASSIGNMENT_DATE"));
		allTask.setBlocked(rs.getBoolean("BLOCKED"));
		allTask.setBlockingReason(rs.getString("BLOCK_REASON"));
		
        return allTask;

    }

}
