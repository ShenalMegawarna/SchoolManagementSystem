package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer>{

	List<Teacher> findByContact(int contact);
	
	List<Teacher> findByAddress(String address);
	
	List<Teacher> findByEmail(String email);
	
	List<Teacher> findByIdGreaterThan(int id);
	
	@Query("from teacher where contact=?1 order by id")
	List<Teacher> findByContactSorted(int contact);
}
