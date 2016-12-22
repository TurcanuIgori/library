package com.library.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.library.entity.Book;

@Repository("bookDAO")
public class BookDAO {
	
	private EntityManager em;

	@Autowired
	public BookDAO(EntityManager em) {
		super();
		this.em = em;
	}
	
	@Transactional
	public Book addBook(Book book){
		em.persist(book);
	    return book;
	}

	@Transactional(propagation=Propagation.REQUIRED)
	public Book updateBook(Book book){
		em.merge(book);
	    return book;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteBook(int id) throws IllegalStateException{		
		em.remove(getBookById(id));
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public Book getBookById(int id) {
		Query query = em.createQuery("Select b From Book as b join fetch b.genre g where b.id = :id");
		query.setParameter("id", id);
		return (Book) query.getSingleResult();
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public Book getBookByISBN(String isbn) {
		Query query = em.createQuery("Select b From Book as b where b.isbn join fetch b.genre g like :isbn");
		query.setParameter("isbn", isbn);
		return (Book) query.getSingleResult();
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Book> findAllBooks() {
		Query query = em.createQuery("Select b From Book as b join fetch b.genre g");
		return (List<Book>) query.getResultList();
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Book> findBooksByTitle(String title) {
		Query query = em.createQuery("Select b From Book as b join fetch b.genre g where b.name like :title");
		query.setParameter("title", title);
		return (List<Book>) query.getResultList();
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<Book> findBooksByGenre(int genre_id) {
		Query query = em.createQuery("Select b From Book as b join fetch b.genre g where g.id = :genre_id");
		query.setParameter("genre_id", genre_id);
		return (List<Book>) query.getResultList();
	}
}
