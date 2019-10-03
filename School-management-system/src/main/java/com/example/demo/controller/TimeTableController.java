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

import com.example.demo.TimeTableRepository;
import com.example.demo.model.TimeTable;

@RestController
public class TimeTableController {

	@Autowired
	TimeTableRepository repo;
	
	@RequestMapping("/time")
	public String timeTable() {
		return "timetable.jsp";
	}
	
	@PostMapping("/timetable")
	public TimeTable addTimeTable(@RequestBody TimeTable timeTable) {
		
		repo.save(timeTable);
		return timeTable;
	}
	
	@RequestMapping("/timeTables")
	public List<TimeTable> getTimeTables(){
		return repo.findAll();
	}
	
	@RequestMapping("/timeTable/{id}")
	public Optional<TimeTable> getTimeTable(@PathVariable int id){
		return repo.findById(id);
	}
	
	@DeleteMapping("/timeTable/{id}")
	public Boolean deleteTimeTable(@PathVariable int id) {
		
		TimeTable t = repo.getOne(id);
		repo.delete(t);
		return true;
	}
	
	@PutMapping("/timeTable")
	public TimeTable updateStudent(@RequestBody TimeTable timeTable) {
		
		repo.save(timeTable);
		return timeTable;
	}
	
}
