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

import com.example.demo.TeacherRepository;
import com.example.demo.model.Teacher;

@RestController
public class TeacherController {

	@Autowired
	TeacherRepository repo;
	
	@RequestMapping("/tea")
	public String Teaacher() {
		return "teacher.jsp";
	}
	
	@PostMapping("/teacher")
	public Teacher addTeacher(@RequestBody Teacher teacher) {
		repo.save(teacher);
		return teacher;
	}
	
	@RequestMapping("/teachers")
	public List<Teacher> getTeacher(){
		return repo.findAll();
	}
	
	@RequestMapping("/teacher/{id}")
	public Optional<Teacher> getStudent(@PathVariable int id){
		return repo.findById(id);
	}
	
	@DeleteMapping("/teacher/{id}")
	public Boolean deleteTeacher(@PathVariable int id) {
		
		Teacher t = repo.getOne(id);
		repo.delete(t);
		return true;
	}
	
	@PutMapping("/teacher")
	public Teacher updateTeacher(@RequestBody Teacher teacher) {
		
		repo.save(teacher);
		return teacher;
	}
	
}
