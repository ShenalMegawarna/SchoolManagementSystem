package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.ClassRoom;

public interface ClassRoomRepository  extends JpaRepository<ClassRoom, Integer>{

	List<ClassRoom> findAllByName(String name);
	List<ClassRoom> findAllByTeacherInCharge(String TeacherInCharge);
	
	List<ClassRoom> findByIdGreaterThan(int id);
	
	@Query("from ClassRoom where name=?1 order by id desc")
	List<ClassRoom> findByNameSort(String name);
	
}
