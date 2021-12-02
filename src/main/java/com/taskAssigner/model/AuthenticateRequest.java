package com.taskAssigner.model;

import org.springframework.security.core.Transient;

@Transient
public class AuthenticateRequest {
	
	private String userName;
	private String password;
	
	public AuthenticateRequest(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}


	public String getPassword() {
		return password;
	}

	
}
