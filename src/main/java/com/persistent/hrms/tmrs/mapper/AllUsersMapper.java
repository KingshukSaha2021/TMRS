package com.persistent.hrms.tmrs.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.persistent.hrms.tmrs.model.Users;

public class AllUsersMapper implements RowMapper<Users>{
	
	@Override
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Users user = new Users();
		
		user.setId(rs.getLong("ID"));
		user.setUserName(rs.getString("USER_NAME"));
		
		return user;
	}

}
