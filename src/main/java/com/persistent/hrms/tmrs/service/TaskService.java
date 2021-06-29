package com.persistent.hrms.tmrs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.hrms.tmrs.repository.TaskRepository;
import com.persistent.hrms.tmrs.repository.TaskServiceRepository;
import com.persistent.hrms.tmrs.model.TaskAssignment;
import com.persistent.hrms.tmrs.model.Tasks;
import com.persistent.hrms.tmrs.repository.TaskAssignmentRepository;
import com.persistent.hrms.tmrs.repository.TaskAssignmentServiceRepository;

@Service
public class TaskService {
	
	TaskRepository TaskRepository;
	TaskServiceRepository taskServiceRepository;
	TaskAssignmentRepository taskAssignmentRepository;
	TaskAssignmentServiceRepository taskAssignmentServiceRepository;
	
	
	@Autowired
	public TaskService(TaskRepository TaskRepository, TaskServiceRepository taskServiceRepository, TaskAssignmentRepository taskAssignmentRepository) {
		this.TaskRepository = TaskRepository;
		this.taskServiceRepository = taskServiceRepository;
		this.taskAssignmentRepository = taskAssignmentRepository;
	}
	

	
	public void updateBlockReason(int taskId, String blockReason) {
		taskAssignmentServiceRepository.updateBlockReason(taskId, blockReason); 
	}
	 
	
	
	public void updateCompletionPercentage(int taskId, int completionPercentage){ 
		taskServiceRepository.updateCompletionPercentage(taskId, completionPercentage); 
	}
	
	public void addTask(Tasks task) {
		TaskRepository.save(task);
	}

	public void assignTask(TaskAssignment taskAssignment) {
		taskAssignmentRepository.save(taskAssignment);
	}
	
	public void updateTask(long taskId, int eta, String description, int priority) { 
		taskServiceRepository.updateTask(taskId, eta, description, priority); 
	}
	
	public void removeTask(long taskId) {
		taskAssignmentRepository.deleteById(taskId);
	}
	
	public List<Tasks> getAllTasks(int id){
		List<Tasks> allTasks = new ArrayList<Tasks>();
			
		
		return allTasks;
	}
}
