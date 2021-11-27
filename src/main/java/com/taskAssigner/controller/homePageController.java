package com.taskAssigner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class homePageController {
	
	@GetMapping("/")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/register")
	public String registrationPage() {
		return "register";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
}
