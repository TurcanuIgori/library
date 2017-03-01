package com.library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.library.repository.UserRepository;
import com.library.entity.User;
@Service
public class UserService {
	
//	@Autowired
//	private UserDAO userDAO;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	public User findById(Long id){
	    return userRepository.findUserById(id);
	}	
	
	public void deleteById(Long id){
		userRepository.delete(id);
	}	
	
	public User findByUsername(String username) {
		return userRepository.findUserByUsername(username);
	}	
	
	public User save(User userForm) {
		userForm.setPassword(passwordEncoder.encode(userForm.getPassword()));		
		return userRepository.save(userForm);		
	}
	
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
}
