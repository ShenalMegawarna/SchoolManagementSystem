package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.BatchRepository;
import com.example.demo.model.Batch;

@RestController
public class BatchController {

	@Autowired
	BatchRepository repo;
	
	@RequestMapping("/bat")
	public String batch() {
		return "batch.jsp";
	}
	
	@PostMapping("/batch")
	public Batch addBatch(@RequestBody Batch batch) {
		repo.save(batch);
		return batch;
		
	}
	
	@RequestMapping("/batchs")
	public List<Batch> getBatchs(){
		return repo.findAll();
	}
	
	@RequestMapping("/batch/{id}")
	public Optional<Batch> getBatch(@PathVariable int id){
		return repo.findById(id);
	}
	
	@DeleteMapping("/batch/{id}")
	public Boolean deleteBatch(@PathVariable int id) {
		Batch b = repo.getOne(id);
		repo.delete(b);
		return true;
	}
	
	@PutMapping("/batch")
	public Batch updateBatch(@RequestBody Batch batch) {
		repo.save(batch);
		return batch;
	}
	
	
}
