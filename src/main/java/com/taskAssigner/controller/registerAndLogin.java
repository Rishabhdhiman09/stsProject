package com.taskAssigner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.taskAssigner.model.AuthenticateRequest;
import com.taskAssigner.model.User;
import com.taskAssigner.service.JwtUtil;
import com.taskAssigner.service.UserService;

@RestController
public class registerAndLogin {
	
	@Autowired
	UserService userService;
	
	
	@PostMapping("/registering")
	public String register(@ModelAttribute User user, Model model) {
		
		model.addAttribute("message", userService.addUser(user));
		return "register";
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticateRequest authenticateRequest) throws Exception{
		
		return userService.authenticate(authenticateRequest);
		
		
	}
	
	@GetMapping("/success")
	public String success() {
		return "success";
	}
}
