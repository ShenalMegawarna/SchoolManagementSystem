package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.AdminRepository;
import com.example.demo.model.Admin;

@Controller
public class AdminController {

	@Autowired
	AdminRepository repo;
	
	@RequestMapping("admin")
	public String admin() {
		
		System.out.println("Admin Page");
		return "admin";
	}
	
	@RequestMapping("/addAdmin")
	public String addAdmin(Admin admin) {
		
		repo.save(admin);
		System.out.println("Admin Saved");
		return "admin";
	}
	
	@RequestMapping("/getAdmin")
	public ModelAndView getAdmin(@RequestParam int id) {
		ModelAndView mv = new ModelAndView("admin");
		Admin admin =  repo.findById(id).orElse(new Admin());
		mv.addObject(admin);
		
		System.out.println("Admin Searched");
		return mv;
	}
	
}
