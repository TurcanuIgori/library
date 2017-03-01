package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.repository.BookRepository;
import com.library.repository.GenreRepository;
import com.library.entity.Book;
import com.library.entity.Genre;

@Service
public class LibraryService {	
	
	@Autowired
	private GenreRepository genreRepository;
	
	@Autowired
	private BookRepository bookRepository;		
	
	public List<Genre> getAllGenre(){
		return genreRepository.findAll();
	}	
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}	
	
	public List<Book> getBooksByGenre(Long genre_id){
		return bookRepository.findBookByGenreId(genre_id);
	}	
	
	public List<Book> getBooksByTitle(String name){
		return bookRepository.findBookByName(name);
	}	
	
	public Book getBookById(Long id){
		return bookRepository.findBookById(id);
	}	
	
	public Book getBookByISBN(String isbn){
		return bookRepository.findBookByIsbn(isbn);
	}	
	
	public void addBook(Book book){
		bookRepository.save(book);
		
	}	
	
	public void deleteBookById(Long id){
		bookRepository.delete(id);
	}
}
