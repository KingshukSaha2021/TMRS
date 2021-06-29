package com.persistent.hrms.tmrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.persistent.hrms.tmrs.model.TaskAssignment;

@Repository
public interface TaskAssignmentRepository extends JpaRepository <TaskAssignment, Long> {

	
	/*
	 * @Modifying
	 * 
	 * @Query("Update TASK_ASSIGNMENT set blocked = true, block_reason = (:blockReason) where task_id = (:taskId)"
	 * ) public void updateBlockReason(@Param("blockReason") String
	 * blockReason, @Param("taskId") int taskId);
	 */
}
