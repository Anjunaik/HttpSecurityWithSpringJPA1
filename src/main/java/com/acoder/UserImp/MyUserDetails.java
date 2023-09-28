package com.acoder.UserImp;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.acoder.pojo.UserEntity;

public class MyUserDetails implements UserDetails {

	/**
	 * 
	 */
	private UserEntity entity;
	private static final long serialVersionUID = 1L;
	
	public MyUserDetails(UserEntity entity) {
		// TODO Auto-generated constructor stub
		this.entity=entity;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		
		SimpleGrantedAuthority authority= new SimpleGrantedAuthority(entity.getRole());
		return  Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return entity.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return entity.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return entity.isEnable();
	}

}
