package com.acoder.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.acoder.pojo.Student;

public interface StudentRepo extends JpaRepository<Student, Serializable> {
	
	@Query(" FROM Student WHERE username =:username")
	public Student finadByUserName( @Param("username") String username);

}
