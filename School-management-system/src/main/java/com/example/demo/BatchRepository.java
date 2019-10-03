package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Batch;

public interface BatchRepository extends JpaRepository<Batch, Integer>{

	List<Batch> findAllByName(String name);
	
	List<Batch> findByIdGreaterThan(int id);
	
	@Query("from Batch where name=?1 order by id desc")
	List<Batch> findByNameSort(String name);
	
}
