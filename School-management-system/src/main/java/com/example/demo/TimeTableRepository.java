package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.TimeTable;

public interface TimeTableRepository extends JpaRepository<TimeTable, Integer>{

	List<TimeTable> findByName(String subjectName);
	
	List<TimeTable> findIdGreaterThan(int id);
	
	@Query("from TimeTable where subjectName=? order b id desc")
	List<TimeTable> findByNameSorted(String subjectName);
	
}
