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

import com.example.demo.SubjectRepository;
import com.example.demo.model.Subject;

@RestController
public class SubjectController {

	@Autowired
	SubjectRepository repo;
	
	@RequestMapping("/sub")
	public String subject() {
		return "subject.jsp";
	}
	
	@PostMapping("/subject")
	public Subject addsubject(Subject subject) {
		repo.save(subject);
		return subject;
	}
	
	@RequestMapping("/subjects")
	public List<Subject> getSubjects(){
		return repo.findAll();
	}
	
	@RequestMapping("/subject/{id}")
	public Optional<Subject> getStudent(@PathVariable int id){
		return repo.findById(id);
	}
	
	@DeleteMapping("/subject/{id}")
	public Boolean deleteSubject(@PathVariable int id) {
		Subject sb = repo.getOne(id);
		repo.delete(sb);
		return true;
	}
	
	@PutMapping("/subject")
	public Subject updateSubject(@RequestBody Subject subject) {
		repo.save(subject);
		return subject;
	}

	
}
