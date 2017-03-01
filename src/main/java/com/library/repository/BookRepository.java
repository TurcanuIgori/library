package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.library.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Long>{

	List<Book> findAll();	
	
	List<Book> findBookByGenreId(Long genre_id);

	List<Book> findBookByName(String name);

	Book findBookById(Long id);

	Book findBookByIsbn(String isbn);
	
	void delete(Long id);
	
	Book save(Book book);	

}
