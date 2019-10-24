package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Parent;
import com.example.demo.model.Student;

public interface ParentRepository extends JpaRepository<Parent, Integer>{

	List<Parent> findByFirstName(String firstName);
	List<Parent> findByLastName(String lastName);
	List<Parent> findByEmail(String email);
	
	List<Parent> findByIdGreaterThan(int id);
	
	@Query("from Parent where contact=?1 order by id desc")
	List<Student> findByContactSorted(int contact);
	
}
