package com.persistent.hrms.tmrs.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistent.hrms.tmrs.model.TaskComment;
import com.persistent.hrms.tmrs.repository.CommentRepository;
import com.persistent.hrms.tmrs.repository.CommentServiceRepository;


@Service
public class CommentkService {
	
	CommentRepository commentRepository;
	CommentServiceRepository commentServiceRepository;
	
	@Autowired
	public CommentkService(CommentRepository commentRepository, CommentServiceRepository commentServiceRepository) {
		this.commentRepository = commentRepository;
		this.commentServiceRepository = commentServiceRepository;
	}
	
	public void addComment(TaskComment comment) {
		commentRepository.save(comment);
	}
	
	public List<TaskComment> getAllComments(long taskId, long userId){
		List<TaskComment> allComments = new ArrayList<TaskComment>();
		
		allComments = commentServiceRepository.getAllComments(taskId, userId);
		
		return allComments;
	}

}
