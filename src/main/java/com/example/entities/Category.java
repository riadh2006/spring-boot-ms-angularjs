package com.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private Long id; 
	private String Name;
	
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Category(String name) {
		super();
		Name = name;
	}


	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	} 
	
	

}
