package com.taskAssigner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taskAssigner.model.User;
import com.taskAssigner.service.UserService;

@Controller
public class registerAndLogin {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/registering")
	public String register(@ModelAttribute User user, Model model) {
		
		model.addAttribute("message", userService.addUser(user));
		return "register";
	}
	
	@PostMapping("/loginProcess")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
		boolean result = userService.autheticateUser(email, password);
		model.addAttribute("passwordStatus", "Authentication: "+ result);
		if (result == true) {
			return "success";
		}
		return "register";
	}
}
