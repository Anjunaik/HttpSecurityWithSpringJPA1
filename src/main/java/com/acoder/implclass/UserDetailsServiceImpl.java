package com.acoder.implclass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.acoder.pojo.Student;
import com.acoder.repo.StudentRepo;

public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	private StudentRepo repo;
	
	@Override
//this will be talks to db with user name and return user details
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		 Student student = repo.finadByUserName(username);
		 
	        if (student == null) {
	            throw new UsernameNotFoundException("Could not find user");
	        }
	         
	        return new StudentImpl(student);
	}

}
