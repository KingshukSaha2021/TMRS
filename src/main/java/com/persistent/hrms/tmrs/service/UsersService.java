package com.persistent.hrms.tmrs.service;

import com.persistent.hrms.tmrs.model.AllTaskModel;
import com.persistent.hrms.tmrs.model.Users;
import com.persistent.hrms.tmrs.repository.UserServiceRespository;
import com.persistent.hrms.tmrs.repository.UsersRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

	private UsersRepository repository;
	@Autowired
	private UserServiceRespository serviceRepository;

	@Autowired
	public UsersService(UsersRepository repository) {
		this.repository = repository;
	}

	public List<Users> findAll() {
		return StreamSupport.stream(repository.findAll().spliterator(), false).collect(Collectors.toList());
	}

	
	public boolean validateUser(Users user) {
	
		System.out.println("Inside UsersService: validateUser");
		
		return serviceRepository.validateUser(user);
	}
	 
	
	public List<AllTaskModel> getAllTasksForEmployee(Users user){ return
		serviceRepository.getAllTasksForEmployee(user); 
	}
	

}
