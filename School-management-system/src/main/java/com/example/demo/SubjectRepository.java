package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer>{

	List<Subject> findByName(String name);
	
	List<Subject> findByIdGreaterThan(int id);
	
	@Query("from Subject where name=?1 order by id desc")
	List<Subject> findByNameSorted(String name);
	
}
