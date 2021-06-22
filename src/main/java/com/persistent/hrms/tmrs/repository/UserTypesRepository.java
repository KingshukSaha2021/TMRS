package com.persistent.hrms.tmrs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.persistent.hrms.tmrs.model.UserTypes;

@Repository
public interface UserTypesRepository extends CrudRepository<UserTypes, Long>{

}
