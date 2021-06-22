package com.persistent.hrms.tmrs.repository;

import com.persistent.hrms.tmrs.mapper.AllTaskRowMapper;
import com.persistent.hrms.tmrs.model.AllTaskModel;
import com.persistent.hrms.tmrs.model.Users;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class UserServiceRespository {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public boolean validateUser(Users user) {
		System.out.println("Inside UserServiceRespository: validateUser");
		
		System.out.println("User Type : " + user.getUserType());
    	System.out.println("User Name : " + user.getUserName());
    	System.out.println("Password : " + user.getPassword());
		
		String sql = "select 1 from USERS where USER_NAME = ? and PASSWORD = ? and USER_TYPE = ? ";
		
		int i;
		
		try {
			i = jdbcTemplate.queryForObject(sql, new Object[] {user.getUserName(), user.getPassword(), user.getUserType()}, Integer.class);
		}catch(Exception e) {
			i = 0;
		}
		
		System.out.println("i : " + i);
		
		if(i == 0)
			return false;
		else
			return true;
	}
	
	
	public List<AllTaskModel> getAllTasksForEmployee(Users user){
		System.out.println("Inside UserServiceRespository: getAllTasksForEmployee");
		
		List<AllTaskModel> allTasks = new ArrayList<AllTaskModel>();
		
		
		String sql = "select id from USERS where USER_NAME = ? and PASSWORD = ? and USER_TYPE = ? ";
		
		int id = jdbcTemplate.queryForObject(sql, new Object[] {user.getUserName(), user.getPassword(), user.getUserType()}, Integer.class);
		 
		System.out.println("Employee Id : " + id);
		 
		sql = "select t.ID, tt.TASK_TYPE, t.PRIORITY, t.NAME, t.DESCRIPTION, t.COMPLETION, t.ETA, t.ASSIGNMENT_DATE, a.BLOCKED, a.BLOCK_REASON from TASKS t, TASK_ASSIGNMENT a, TASK_TYPES tt where t.ID = a.TASK_ID and t.TYPE = tt.ID "
				+ "and a.USER_ID = ? order by t.PRIORITY desc, t.ID desc, tt.TASK_TYPE desc, t.COMPLETION desc "; 
		 
		allTasks = jdbcTemplate.query(sql, new Object[] {id}, new AllTaskRowMapper());
		 
		
		return allTasks;
	}
	
}
