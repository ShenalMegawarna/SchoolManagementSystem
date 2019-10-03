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

import com.example.demo.ClassRoomRepository;
import com.example.demo.model.ClassRoom;

@RestController
public class ClassRoomController {

	@Autowired
	ClassRoomRepository repo;
	
	@RequestMapping("/cls")
	public String classRoom() {
		return "classRoom.jsp";
	}
	
	@PostMapping("/classroom")
	public ClassRoom addClassRoom(@RequestBody ClassRoom classroom) {
		repo.save(classroom);
		return classroom;
		
	}
	
	@RequestMapping("/classrooms")
	public List<ClassRoom> getClassRooms(){
		return repo.findAll();
	}
	
	@RequestMapping("/classroom/{id}")
	public Optional<ClassRoom> getClassRoom(@PathVariable int id){
		return repo.findById(id);
	}
	
	@DeleteMapping("/classroom/{id}")
	public Boolean deleteClassRoom(@PathVariable int id) {
		ClassRoom cr = repo.getOne(id);
		repo.delete(cr);
		return true;
	}
	
	@PutMapping("/classroom")
	public ClassRoom updateClassRoom(@RequestBody ClassRoom classroom) {
		repo.save(classroom);
		return classroom;
	}
	
}
