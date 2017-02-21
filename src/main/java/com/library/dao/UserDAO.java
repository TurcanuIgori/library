package com.library.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.library.entity.User;
@Repository("userDAO")
public class UserDAO {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(UserDAO.class);
	
	
//	private EntityManagerFactory emf;
	
	private EntityManager em;

	@Autowired
	public UserDAO(EntityManager em) {
		super();
		this.em = em;
	}

	// delete user by id
	public void deleteStudent(int id) throws IllegalStateException{		
		em.remove(getStudentById(id));
		logger.info("User had been removed.");
	}
	
	public User getStudentById(int id) {
		Query query = em.createQuery("Select u From User as u where u.id = :id");
		query.setParameter("id", id);
		return (User) query.getSingleResult();
	}
	
	public User findByUsername(String username) {
		Query query = em.createQuery("Select u From User as u where u.username = :username");
		query.setParameter("username", username);
		User newUser = (User) query.getSingleResult();
		return newUser;
	}
	
	public User addUser(User user){
		em.persist(user);
	    return user;
	}
	
	public User updateUser(User user){
		em.merge(user);
	    return user;
	}
	
	public List<User> findAllUsers() {
		Query query = em.createQuery("Select u From User as u");
		return (List<User>) query.getResultList();
	}
}
