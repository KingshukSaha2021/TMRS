package com.persistent.hrms.tmrs.controller;


import com.persistent.hrms.tmrs.model.Users;
import com.persistent.hrms.tmrs.model.AllTaskModel;
import com.persistent.hrms.tmrs.model.TaskComment;
import com.persistent.hrms.tmrs.service.UserTypesService;
import com.persistent.hrms.tmrs.service.UsersService;
import com.persistent.hrms.tmrs.service.TaskService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import java.util.List;

@Controller
public class TMRSController {

    private UserTypesService service;
    private UsersService userService;
    private TaskService taskService;

    @Autowired
    public TMRSController(UserTypesService service, UsersService userService, TaskService taskService) {
    	this.service = service;
        this.userService = userService;
        this.taskService = taskService;
    }
    
    @GetMapping
    public String showLoginPage(Model model) {
    	Users users = new Users();
        model.addAttribute("UserTypes", service.findAll());
        model.addAttribute("users", users);
        model.addAttribute("validUser", true);
        return "Login";
    }

    @PostMapping("/login-user") 
    public String performLogin(Model model, @Valid @ModelAttribute Users users ) {
    	
    	System.out.println("inside performLogin");
    	
    	System.out.println("User Type : " + users.getUserType());
    	System.out.println("User Name : " + users.getUserName());
    	System.out.println("Password : " + users.getPassword());
    	
    	
    	if(!userService.validateUser(users)) {
    		Users users1 = new Users();
            model.addAttribute("UserTypes", service.findAll());
            model.addAttribute("users", users1);
            model.addAttribute("validUser", false);
    		return "Login";
    	}
    	
    	
    	model.addAttribute("user", users); 
    	
    	if(users.getUserType() == 1) {
    		List<AllTaskModel> allTasks = userService.getAllTasksForEmployee(users);
    		model.addAttribute("allTasks", allTasks); 
    		return "EmployeeLandingPage"; 
    	}
    	
    	if(users.getUserType() == 2) {
    		return "ManagerLandingPage"; 
    	}
    	
    	return "EmployeeLandingPage";
    }
    
    @PostMapping("/saveEmployee") 
    public String saveEmployeeDetail(Model model, @Valid @ModelAttribute AllTaskModel task) {
    	
    	
    	
    	return "EmployeeLandingPage";
    }
    
    @PostMapping("/addComment")
    public String addComment(Model model, @Valid @ModelAttribute TaskComment comment) {
    	
    	taskService.addComment(comment);
    	
    	
    	return "EmployeeLandingPage";
    }
    
    @PostMapping("/logOff")
    public String logOff(Model model, HttpServletRequest request) {
    	HttpSession session = request.getSession();
    	session.invalidate();
    	Users users1 = new Users();
        model.addAttribute("UserTypes", service.findAll());
        model.addAttribute("users", users1);
        model.addAttribute("validUser", false);
		return "Login";
    }
    
}
