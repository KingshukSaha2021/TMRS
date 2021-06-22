package com.persistent.hrms.tmrs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.persistent.hrms.tmrs.model.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long>{

	
}
