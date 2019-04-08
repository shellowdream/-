package com.dome.hibernateDemo;

import java.util.HashSet;
import java.util.Set;

public class Actor {
	private String name;
	private Long id;
	private Set<Role> roles = new HashSet<Role>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "Actor [name=" + name + ", id=" + id + ", roles=" + roles + "]";
	}
	
	
}
