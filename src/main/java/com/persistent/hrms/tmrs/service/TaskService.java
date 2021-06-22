package com.persistent.hrms.tmrs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.hrms.tmrs.model.TaskComment;
import com.persistent.hrms.tmrs.repository.TaskRepository;
import com.persistent.hrms.tmrs.repository.UsersRepository;

@Service
public class TaskService {
	
	TaskRepository TaskRepository;
	
	@Autowired
	public TaskService(TaskRepository TaskRepository) {
		this.TaskRepository = TaskRepository;
	}
	
	
	public void addComment(TaskComment comment) {
		TaskRepository.addComment(comment);
	}

}
