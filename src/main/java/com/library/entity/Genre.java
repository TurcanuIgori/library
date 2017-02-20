package com.library.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="genre")
public class Genre implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
//	@Pattern(regexp="^(([A-Za-z]+)(\\s[A-Za-z]+)*)$", message="Invalid genre.")
//	@Size(min=4, max=20, message="Genre must be between 4 and 20 characters long.")
	@Column
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
	@Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.name);
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
    	 
    	 final Genre genre = (Genre) obj;
    	 
    	 if (!Objects.equals(this.id, genre.id)) {
             return false;
         }
    	 
    	 if (!Objects.equals(this.name, genre.name)) {
             return false;
         }    	 
    	 
    	 return true;
    }
}