package com.taskAssigner.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.taskAssigner.Repository.UserRepository;
import com.taskAssigner.model.AuthenticateRequest;
import com.taskAssigner.model.AuthenticateResponse;
import com.taskAssigner.model.Role;
import com.taskAssigner.model.Task;
import com.taskAssigner.model.User;
import com.taskAssigner.util.Constants;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	JwtUtil jwtUtil;
	
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

	public ResponseEntity<?> authenticate(AuthenticateRequest authenticateRequest) throws Exception {
		// TODO Auto-generated method stub
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticateRequest.getUserName(), authenticateRequest.getPassword())
				);
		}catch (BadCredentialsException e) {
			throw new Exception("Incorrect username and password", e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticateRequest.getUserName());
		
		final String jwt = jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok(new AuthenticateResponse(jwt));
	}
	
//	public boolean autheticateUser(String email, String password) {
//		try {
//			User user = userRepository.findByEmail(email);
//			if (user != null) {
//				return true;
//			}
//		}catch (Exception e) {
//			// logger will be added later
//		}
//		return false;
//		
//	}
}

