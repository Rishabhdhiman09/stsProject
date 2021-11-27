package com.taskAssigner.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.taskAssigner.Repository.UserRepository;
import com.taskAssigner.model.Role;
import com.taskAssigner.model.Task;
import com.taskAssigner.model.User;
import com.taskAssigner.util.Constants;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	public String addUser(User user) {
		try {
			if (userRepository.findByEmail(user.getEmail()) != null) {
				return Constants.ALREADY_EXIST;
			}
			List<Role> roles = new ArrayList<>();
			Role role = new Role("USER");
			
			roles.add(role);
			user.setRoles(roles);
			userRepository.save(user);
			return Constants.SUCCESS;
		}catch (Exception e) {
			return Constants.FAILURE;
		}
		
	}
	
	public boolean autheticateUser(String email, String password) {
		try {
			User user = userRepository.findByEmail(email);
			if (user != null) {
				return true;
			}
		}catch (Exception e) {
			// logger will be added later
		}
		return false;
		
	}
}
