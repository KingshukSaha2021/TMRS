package com.persistent.hrms.tmrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.persistent.hrms.tmrs.model.Tasks;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Long>{
	
	/*
	 * @Modifying
	 * 
	 * @Query("Update TASKS set completion = ?2 where id = ?1") public void
	 * updateCompletionById(int taskId, int complementionPercentage);
	 */
	
	
	
	/*
	 * @Modifying
	 * 
	 * @Query("Update TASKS set eta = ?2, description = ?3, priority = ?4 where id = ?1"
	 * ) public void updateById(long taskId, int eta, String description, int
	 * priority);
	 */
	 

}
