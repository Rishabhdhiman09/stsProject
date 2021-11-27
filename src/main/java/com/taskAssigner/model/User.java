package com.taskAssigner.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
//	@Email(message = "Email should be valid")
	@NotNull
	@Column
	private String email;
	
	@Column
	@NotNull
	private String name;
	
	@Column
	@NotNull
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private List<Task> tasks;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "rolesUser", 
			  joinColumns = @JoinColumn(name = "userId"), 
			  inverseJoinColumns = @JoinColumn(name = "roleId"))
	private List<Role> roles;

	public User(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}
	
	
	public User() {
		
	}

	
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Task> getTasks() {
		return tasks;
	}


	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	

}
