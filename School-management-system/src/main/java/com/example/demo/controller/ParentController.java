package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ParentRepository;
import com.example.demo.model.Parent;

@RestController
public class ParentController {

	@Autowired
	ParentRepository repo;
	
	@RequestMapping("/pare")
	public String home() {
		return "para.jsp";
	}
	
	@PostMapping("/parent")
	public Parent addParent(@RequestBody Parent parent) {
		repo.save(parent);
		return parent;
	}
	
	@RequestMapping("/parents")
	
	public List<Parent> getParents(){
		return repo.findAll();
	}
	
	@RequestMapping("/parent/{id}")
	public Optional<Parent> getParent(@PathVariable int id){
		return repo.findById(id);
	}
	
	
	@DeleteMapping("/parent/{id}")
	public Boolean deleteParent(@PathVariable int id) {
		Parent p = repo.getOne(id);
		repo.delete(p);
		return true;
	}
	
	@PutMapping("/parent")
	public Parent updateParent(@RequestBody Parent parent) {
		
		repo.save(parent);
		return parent;
		
	}
	
}
