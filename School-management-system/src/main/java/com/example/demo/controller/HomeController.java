package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String home() {
		
		System.out.println("Home Page");
		return "home";
	}
	
	@RequestMapping("/login")
	public String login() {
		
		System.out.println("Login Page");
		return "login";
	}
	
	
	
}
