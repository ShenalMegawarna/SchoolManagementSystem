package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

	List<Student> findByContact(int contact);
	
	List<Student> findByAddress(String address);
	
	List<Student> findByEmail(String email);
	
	List<Student> findByIdGreaterThan(int id);
	
	@Query("from Student where contact=?1 order by id desc")
	List<Student> findByContactSorted(int contact);
	
}
