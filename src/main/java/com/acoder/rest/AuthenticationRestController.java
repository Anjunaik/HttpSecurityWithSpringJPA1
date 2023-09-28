package com.acoder.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationRestController {


	@GetMapping(value="/greet")
	public String greet()
	{
		return "Welcome to A-coder site....!";
	}
	

	
}
