package com.library.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="author")
public class Author {
	
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
//	@Pattern(regexp="^(([A-Za-z]+)(\\s[A-Za-z]+)*)$", message="Invalid first name.")
//	@Size(min=4, max=20, message="Your first name must be between 4 and 20 characters long.")
	@Column
	private String firstName;
	
//	@Pattern(regexp="^(([A-Za-z]+)(\\s[A-Za-z]+)*)$", message="Invalid last name.")
//	@Size(min=4, max=20, message="Your last name must be between 4 and 20 characters long.")
	@Column
	private String lastName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}