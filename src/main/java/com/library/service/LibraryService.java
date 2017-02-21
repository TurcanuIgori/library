package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.dao.BookRepository;
import com.library.dao.GenreRepository;
import com.library.entity.Book;
import com.library.entity.Genre;

@Service
public class LibraryService {	
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Autowired
	private BookRepository bookRepository;
		
	@Transactional
	public List<Genre> getAllGenre(){
		return genreRepository.findAll();
	}
	
	@Transactional
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	@Transactional
	public List<Book> getBooksByGenre(Long genre_id){
		return bookRepository.findBookByGenreId(genre_id);
	}
	
	@Transactional
	public List<Book> getBooksByTitle(String name){
		return bookRepository.findBookByName(name);
	}
	
	@Transactional
	public Book getBookById(Long id){
		return bookRepository.findBookById(id);
	}
	
	@Transactional
	public Book getBookByISBN(String isbn){
		return bookRepository.findBookByIsbn(isbn);
	}
	
	@Transactional
	public void addBook(Book book){
		bookRepository.save(book);
		
	}
	
	@Transactional
	public void deleteBookById(Long id){
		bookRepository.delete(id);
	}
}
