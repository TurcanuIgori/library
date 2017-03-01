package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.library.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{

	@Transactional(propagation = Propagation.SUPPORTS)
	List<Book> findAll();	
	
	@Transactional(propagation = Propagation.SUPPORTS)
	List<Book> findBookByGenreId(Long genre_id);

	@Transactional(propagation = Propagation.SUPPORTS)
	List<Book> findBookByName(String name);

	@Transactional(propagation = Propagation.SUPPORTS)
	Book findBookById(Long id);

	@Transactional(propagation = Propagation.SUPPORTS)
	Book findBookByIsbn(String isbn);
	
	@Transactional(propagation = Propagation.REQUIRED)
	void delete(Long id);
	
	@Transactional(propagation = Propagation.REQUIRED)
	Book save(Book book);	

}
