package com.library.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.library.entity.Genre;

@Repository("genreDAO")
public class GenreDAO {
	
	private EntityManager em;

	@Autowired	
	public GenreDAO(EntityManager em) {
		super();
		this.em = em;
	}

	@Transactional
	public Genre addGenre(Genre genre){
		em.persist(genre);
	    return genre;
	}
	
	@Transactional
	public Genre updateGenre(Genre genre){
		em.merge(genre);
	    return genre;
	}
	
	@Transactional
	public List<Genre> findAllGenres() {
		Query query = em.createQuery("Select g From Genre as g");
		return (List<Genre>) query.getResultList();
	}
	
	@Transactional
	public Genre getGenreById(int id) {
		Query query = em.createQuery("Select g From Genre as g where g.id = :id");
		query.setParameter("id", id);
		return (Genre) query.getSingleResult();
	}

	
}
