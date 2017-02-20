package com.library.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import com.library.entity.enums.UserRoleEnum;

@Entity
@Table(name="users")
@NamedQuery(name = "User.findByUsername", query = "select u from User u where u.username = ?1")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message="Please provide an email.")
	@Pattern(regexp="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}",	message="Invalid email address.")
	@Column
	private String username;
	
//	@Size(min=5, max=20, message="Your password must be between 6 and 20 characters long.")
	@Column
	private String password;
	
	@Transient
	private String confirmPassword;
	
	@Enumerated(EnumType.STRING)
	@Column
	private UserRoleEnum role;
	
	@Pattern(regexp="^(([A-Za-z]+)(\\s[A-Za-z]+)*)$", message="Invalid first name.")
	@Size(min=4, max=20, message="Your first name must be between 4 and 20 characters long.")
	@Column
	private String firstName;
	
	@Pattern(regexp="^(([A-Za-z]+)(\\s[A-Za-z]+)*)$", message="Invalid last name.")
	@Size(min=4, max=20, message="Your last name must be between 4 and 20 characters long.")
	@Column
	private String lastName;
	
	@Column
	private String picture;
	
	@Pattern(regexp="^[0-9]{9,14}$", message="Invalid phone.")
	@Size(min=9, max=14, message="Your phone must be between 9 and 14 characters long.")
	@Column
	private String phone;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
//	@Temporal(TemporalType.DATE)
	@Column
	private Date dob;
	
	@Column
	private String gender;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public UserRoleEnum getRole() {
		return role;
	}
	public void setRole(UserRoleEnum role) {
		this.role = role;
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
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
    
	@Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.username);
        hash = 47 * hash + Objects.hashCode(this.password);
        hash = 47 * hash + Objects.hashCode(this.gender);
        hash = 47 * hash + Objects.hashCode(this.dob);
        hash = 47 * hash + Objects.hashCode(this.phone);
        hash = 47 * hash + Objects.hashCode(this.picture);   
        hash = 47 * hash + Objects.hashCode(this.firstName);
        hash = 47 * hash + Objects.hashCode(this.lastName);
        hash = 47 * hash + Objects.hashCode(this.role); 
        return hash;
    }
	
	@Override
    public boolean equals(Object obj) {
    	
    	if (this == obj) {
             return true;
         }
    	
    	if (obj == null) {
             return false;
         }
    	
    	if (getClass() != obj.getClass()) {
             return false;
         }
    	 
    	 final User user = (User) obj;
    	 
    	 if (!Objects.equals(this.id, user.id)) {
             return false;
         }
    	 
    	 if (!Objects.equals(this.username, user.username)) {
             return false;
         }  
    	 
    	 if (!Objects.equals(this.password, user.password)) {
             return false;
         } 
    	 if (!Objects.equals(this.gender, user.gender)) {
             return false;
         }
    	 
    	 if (!Objects.equals(this.dob, user.dob)) {
             return false;
         }  
    	 
    	 if (!Objects.equals(this.phone, user.phone)) {
             return false;
         } 
    	 
    	 if (!Objects.equals(this.picture, user.picture)) {
             return false;
         }  
    	 
    	 if (!Objects.equals(this.firstName, user.firstName)) {
             return false;
         } 
    	 if (!Objects.equals(this.lastName, user.lastName)) {
             return false;
         }  
    	 
    	 if (!Objects.equals(this.role, user.role)) {
             return false;
         } 
    	 
    	 return true;
    }
}