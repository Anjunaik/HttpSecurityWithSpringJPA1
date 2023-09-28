package com.acoder.implclass;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.acoder.pojo.Student;

public class StudentImpl implements UserDetails {

	/**
	 * 
	 */
	
	private Student student;
	
	private static final long serialVersionUID = 1L;
	
	StudentImpl(Student student)
	{
		this.student=student;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// this method gives authority to user
		SimpleGrantedAuthority authority= new  SimpleGrantedAuthority(student.getRole());
		
		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		//password verification
		return student.getPassword();
	}

	@Override
	public String getUsername() {
		//User name verification
		return student.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// account details
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// this method specify lock or unlock our account
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
		return student.isEnable();
	}

}
