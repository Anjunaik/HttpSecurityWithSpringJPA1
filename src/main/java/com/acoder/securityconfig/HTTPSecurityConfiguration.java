package com.acoder.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.acoder.implclass.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class HTTPSecurityConfiguration {

	
	//GET USER DATA FORM DB WITH JPA
	//THIS METHOD CALL USERdETAILSIMPL CLASS constructor
	@Bean
	UserDetailsService detailsService()
	{
		return new UserDetailsServiceImpl();
	}

	
	
	//PASSWORD ENCODER 
	@Bean
	PasswordEncoder encoder()
	{
		return new BCryptPasswordEncoder();
	}
	
	//AUTHORIZATION TO USER
	@Bean
	SecurityFilterChain chain(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests((auth)->
		auth.requestMatchers("/greet").permitAll()
		.anyRequest().authenticated()
		
				)
		//DEFAULT LOGIN FORM
		.formLogin(Customizer.withDefaults());
		
		return http.build();
		
	}
	
}
