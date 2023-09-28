package com.acoder.UserImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.acoder.pojo.UserEntity;
import com.acoder.repo.JpaRepo;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private JpaRepo jpaRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		System.out.println(username);
		
		 UserEntity user = jpaRepo.getUserByUsername(username) ;
		 System.out.println(user);
         
	        if (user == null) {
	            throw new UsernameNotFoundException("Could not find user");
	        }
	         
	        return new MyUserDetails(user);
	}

}
