package com.persistent.hrms.tmrs.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class TaskTypes {
	
	@Id
	private long id;
	private String taskType;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTaskType() {
		return taskType;
	}
	public void setTaskType(String taskType) {
		this.taskType = taskType;
	}
	
}
