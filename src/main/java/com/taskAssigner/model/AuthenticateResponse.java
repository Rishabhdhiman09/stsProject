package com.taskAssigner.model;

import org.springframework.security.core.Transient;

@Transient
public class AuthenticateResponse {
	private final String jwt;

	public String getJwt() {
		return jwt;
	}

	public AuthenticateResponse(String jwt) {
		this.jwt = jwt;
	}
	
	
}
