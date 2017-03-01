package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.library.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long>{
	
	@Transactional(propagation = Propagation.SUPPORTS)
	Author findAuthorById(Long id);
	
	@Transactional(propagation = Propagation.SUPPORTS)
	Author findAuthorByFirstNameAndLastName(String firstName, String lastName);
	
	@Transactional(propagation = Propagation.REQUIRED)
	void delete(Author author);
	
	@Transactional(propagation = Propagation.REQUIRED)
	Author save(Author author);
	
	@Transactional(propagation = Propagation.SUPPORTS)
	List<Author> findAll();
}
