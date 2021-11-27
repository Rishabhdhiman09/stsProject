package com.taskAssigner.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String description;
	
	@Column
	private String timeInHrs;
	
	@ManyToOne
	@JoinColumn(name = "taskId")
	private User user;

	public Task(String description, String timeInHrs) {
		this.description = description;
		this.timeInHrs = timeInHrs;
	}
	
	public Task() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTimeInHrs() {
		return timeInHrs;
	}

	public void setTimeInHrs(String timeInHrs) {
		this.timeInHrs = timeInHrs;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
	
}
