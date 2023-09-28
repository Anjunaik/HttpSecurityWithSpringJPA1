package com.acoder.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@Column(name="ID")
	private Integer id;
	
	@Column(name="NAME")
	private String username;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="ROLE")
	private String role;

	@Column(name="ENABLE")
    private boolean enable;
}
