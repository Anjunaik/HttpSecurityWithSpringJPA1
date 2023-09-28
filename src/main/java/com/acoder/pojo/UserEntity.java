package com.acoder.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "USER_DETAILS")
public class UserEntity {

	
@Id
@GeneratedValue
@Column(name = "USER_ID")
private Integer id;
	
@Column(name = "USER_NAME")
	private String username;
	
@Column(name = "USER_PASSWORD")
	private  String password;
	
@Column(name = "USER_EMAIL")
	private  String email;
	
@Column(name="USER_ENABLE")
private boolean enable;

@Column(name = "USER_ROLE")
	private String role;
	
}
