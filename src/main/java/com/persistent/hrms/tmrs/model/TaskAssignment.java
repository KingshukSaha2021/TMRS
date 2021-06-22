package com.persistent.hrms.tmrs.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TaskAssignment {
	
	@Id
	private long taskId;
	private long userId;
	private boolean blocked;
	private String blockReason;
	
	public long getTaskId() {
		return taskId;
	}
	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public boolean isBlocked() {
		return blocked;
	}
	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}
	public String getBlockReason() {
		return blockReason;
	}
	public void setBlockReason(String blockReason) {
		this.blockReason = blockReason;
	}
	
}
