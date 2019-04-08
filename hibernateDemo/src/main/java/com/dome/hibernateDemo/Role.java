package com.dome.hibernateDemo;

import java.util.HashSet;
import java.util.Set;

public class Role {
	private String name;
	private Long id;
	
	private Set<Actor> actors = new HashSet<Actor>();

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

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	@Override
	public String toString() {
		return "Role [name=" + name + ", id=" + id + ", actors=" + actors + "]";
	}
	
	
}
