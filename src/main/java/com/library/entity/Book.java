package com.library.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name="book")
public class Book {
	
	@Id  
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Size(min=5, max=50, message="Name of book must be between 5 and 50 characters long.")
	@Column
	private String name;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@Valid
	private Author author;
	
	@Column
	private String picturePath;
	
	@Pattern(regexp="^[0-9]{2,5}$", message="Invalid number of pages of Book.")
	@Column
	private int pages;
	
	@Size(min=5, max=30, message="Publisher must be between 5 and 30 characters long.")
	@Column
	private String publisher;
	
	@Pattern(regexp="^[0-9]{4,4}$", message="Invalid year of Book.")
	@Column
	private int year;
	
	@Size(min=5, max=30, message="ISBN must be between 5 and 30 characters long.")
	@Column
	private String isbn;
	
	@Size(min=10, max=20, message="Description must be between 6 and 100 characters long.")
	@Column
	private String description;
	
	@Column
	private String bookPath;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private Genre genre;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
}