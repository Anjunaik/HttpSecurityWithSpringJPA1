package com.acoder.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

import com.acoder.UserImp.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class HttpConfoguration {

	@Bean
	UserDetailsService detailsService()
	{
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        //url- access types
         http.authorizeHttpRequests((authz) -> authz
                       .anyRequest()
                       .authenticated()
                        )
         
         //default login pages
         .formLogin(withDefaults())
  		.httpBasic(withDefaults())
         
  		//default exception handlers
  		.exceptionHandling(((exceptionHandling) ->
 				exceptionHandling
 					.accessDeniedPage("/denied"))
 					);

  		return http.build();
	}
}
