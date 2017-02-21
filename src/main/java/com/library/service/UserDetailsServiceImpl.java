package com.library.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.library.entity.User;
import com.library.entity.enums.UserRoleEnum;
@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserService userService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        User user = userService.findByUsername(username);
        
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(user.getRole().name()));
         
        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(user.getUsername(), 
                                                                       user.getPassword(), 
                                                                       roles);
 
        return userDetails;
	}

}
