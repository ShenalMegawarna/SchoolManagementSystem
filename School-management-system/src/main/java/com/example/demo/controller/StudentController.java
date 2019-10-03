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

import com.example.demo.StudentRepository;
import com.example.demo.model.Student;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository repo;
	
	@RequestMapping("/stu")
	public String student() {
		return "student.jsp";
	}
	
	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {
		
		repo.save(student);
		return student;
	}
	
	@RequestMapping("/students")
	public List<Student> getStudents(){
		return repo.findAll();
	}
	
	@RequestMapping("/student/{id}")
	public Optional<Student> getStudent(@PathVariable int id){
		return repo.findById(id);
	}
	
	@DeleteMapping("/student/{id}")
	public Boolean deleteStudent(@PathVariable int id) {
		
		Student s = repo.getOne(id);
		repo.delete(s);
		return true;
	}
	
	@PutMapping("/student")
	public Student updateStudent(@RequestBody Student student) {
		
		repo.save(student);
		return student;
	}

}
