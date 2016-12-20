package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.library.dao.UserDAO;
import com.library.dao.UserRepository;
import com.library.entity.User;
@Service
public class UserService {
	
	@Autowired
	private UserDAO userDAO;
	
//	@Autowired
//	UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public User findById(int id){
	    return userDAO.getStudentById(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public void deleteById(int id){
	    userDAO.deleteStudent(id);
	}
	
	@Transactional(propagation=Propagation.SUPPORTS)
	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
	}
	@Transactional(propagation=Propagation.REQUIRED)
	public User save(User userForm) {
		userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));
		if(userForm.getId() == 0){
			return userDAO.addUser(userForm);
		}else if(userForm.getId() != 0){
			return userDAO.updateUser(userForm);
		}
		return null;
	}
	@Transactional(propagation=Propagation.SUPPORTS)
	public List<User> findAllUsers() {
		return userDAO.findAllUsers();
	}
}
