package com.library.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="book")
public class Book implements Serializable{
		
	private static final long serialVersionUID = 1L;

	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
//	@Size(min=5, max=50, message="Name of book must be between 5 and 50 characters long.")
	@Column
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
//	@Valid
	private Author author;
	
	@Column
	private String picturePath;
	
//	@Pattern(regexp="^[0-9]{2,5}$", message="Invalid number of pages of Book.")
	@Column
	private int pages;
	
//	@Size(min=5, max=30, message="Publisher must be between 5 and 30 characters long.")
	@Column
	private String publisher;
	
//	@Pattern(regexp="^[0-9]{4,4}$", message="Invalid year of Book.")
	@Column
	private int year;
	
//	@Size(min=5, max=30, message="ISBN must be between 5 and 30 characters long.")
	@Column
	private String isbn;
	
//	@Size(min=10, max=20, message="Description must be between 6 and 100 characters long.")
	@Column
	private String description;
	
	@Column
	private String bookPath;
	
	@ManyToOne(cascade=CascadeType.DETACH, fetch=FetchType.LAZY)
	@JoinColumn(name="genre_id", referencedColumnName="id")
//	@JoinTable(name="book_genre", joinColumns={@JoinColumn(name="book_id")}, inverseJoinColumns={@JoinColumn(name="id")})
	private Genre genre;
	
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
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public int getPages() {
		return pages;
	}
	public void setPages(int pages) {
		this.pages = pages;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBookPath() {
		return bookPath;
	}
	public void setBookPath(String bookPath) {
		this.bookPath = bookPath;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        hash = 47 * hash + Objects.hashCode(this.name);
        hash = 47 * hash + Objects.hashCode(this.year);
        hash = 47 * hash + Objects.hashCode(this.pages);
        hash = 47 * hash + Objects.hashCode(this.isbn);
        hash = 47 * hash + Objects.hashCode(this.author);
        hash = 47 * hash + Objects.hashCode(this.picturePath);
        hash = 47 * hash + Objects.hashCode(this.bookPath);
        hash = 47 * hash + Objects.hashCode(this.description);
        hash = 47 * hash + Objects.hashCode(this.publisher);
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
    	 
    	 final Book book = (Book) obj;
    	 
    	 if (!Objects.equals(this.id, book.id)) {
             return false;
         }
    	 
    	 if (!Objects.equals(this.name, book.name)) {
             return false;
         }  
    	 
    	 if (!Objects.equals(this.year, book.year)) {
             return false;
         } 
    	 if (!Objects.equals(this.pages, book.pages)) {
             return false;
         }
    	 
    	 if (!Objects.equals(this.isbn, book.isbn)) {
             return false;
         }  
    	 
    	 if (!Objects.equals(this.author, book.author)) {
             return false;
         } 
    	 
    	 if (!Objects.equals(this.picturePath, book.picturePath)) {
             return false;
         }  
    	 
    	 if (!Objects.equals(this.bookPath, book.bookPath)) {
             return false;
         } 
    	 if (!Objects.equals(this.description, book.description)) {
             return false;
         }  
    	 
    	 if (!Objects.equals(this.publisher, book.publisher)) {
             return false;
         } 
    	 
    	 return true;
    }
}