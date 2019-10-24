package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.TimeTable;

public interface TimeTableRepository extends JpaRepository<TimeTable, Integer>{

	List<TimeTable> findBysubjectName(String subjectName);
	
	List<TimeTable> findByIdGreaterThan(int id);
	
	@Query("from TimeTable where subjectName=?1 order by id desc")
	List<TimeTable> findByNameSorted(String subjectName);
	
}
