package com.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.library.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	
	@Transactional(propagation=Propagation.SUPPORTS)
	User findUserByUsername(String username);

	@Transactional(propagation=Propagation.SUPPORTS)
	User findUserById(Long id);
	
	@Transactional(propagation=Propagation.SUPPORTS)
	void delete(User user);
	
	@Transactional(propagation=Propagation.SUPPORTS)
	List<User> findAll();
	
	@Transactional(propagation = Propagation.REQUIRED)
	User save(User user);
}
