package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.library.dao.AuthorDAO;
import com.library.dao.BookDAO;
import com.library.dao.GenreDAO;
import com.library.entity.Book;
import com.library.entity.Genre;

@Service
public class LibraryService {
	
	@Autowired
	private AuthorDAO authorDAO;
	@Autowired
	private GenreDAO genreDAO;
	@Autowired
	private BookDAO bookDAO;
	
	@Transactional
	public List<Genre> getAllGenre(){
		return genreDAO.findAllGenres();
	}
	
	@Transactional
	public List<Book> getAllBooks(){
		return bookDAO.findAllBooks();
	}
	
	@Transactional
	public List<Book> getBooksByGenre(int genre_id){
		return bookDAO.findBooksByGenre(genre_id);
	}
	
	@Transactional
	public List<Book> getBooksByTitle(String title){
		return bookDAO.findBooksByTitle(title);
	}
	
	@Transactional
	public Book getBookById(int id){
		return bookDAO.getBookById(id);
	}
	
	@Transactional
	public Book getBookByISBN(String isbn){
		return bookDAO.getBookByISBN(isbn);
	}
	
	@Transactional
	public void addBook(Book book){
		bookDAO.addBook(book);
	}
	
	@Transactional
	public void updateBook(Book book){
		bookDAO.updateBook(book);
	}
	
	@Transactional
	public void deleteBookById(int id){
		bookDAO.deleteBook(id);
	}
}
