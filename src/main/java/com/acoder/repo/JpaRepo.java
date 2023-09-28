package com.acoder.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.acoder.pojo.UserEntity;

public interface JpaRepo extends JpaRepository<UserEntity,Serializable> {
	
	

    @Query(" FROM UserEntity  WHERE username =:username")
	public UserEntity getUserByUsername(String username);

}
