package com.library.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.library.entity.Author;

@Repository("authorDAO")
public class AuthorDAO {
	
	private EntityManager em;

	@Autowired
	public AuthorDAO(EntityManager em) {
		super();
		this.em = em;
	}
	
	@Transactional
	public Author getAuthorById(Long id) {
		Query query = em.createQuery("Select a From Author as a where a.id = :id");
		query.setParameter("id", id);
		return (Author) query.getSingleResult();
	}
	
	@Transactional
	public Author getAuthorByFirtLastName(Author author) {
		Query query = em.createQuery("Select a From Author as a where a.firstName like :firstName and a.lastName like :lastName");
		query.setParameter("firstName", author.getFirstName());
		query.setParameter("lastName", author.getLastName());
		return (Author) query.getSingleResult();
	}
	
	@Transactional
	public Author addAuthor(Author author){
		em.persist(author);
	    return author;
	}
	
	@Transactional
	public Author updateAuthor(Author author){
		em.merge(author);
	    return author;
	}
	
	@Transactional
	public List<Author> findAllAuthors() {
		Query query = em.createQuery("Select a From Author as a");
		return (List<Author>) query.getResultList();
	}
}
