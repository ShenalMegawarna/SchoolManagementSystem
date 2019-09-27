package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Teacher;

public interface TeacherRepository extends CrudRepository<Teacher, Integer>{

}
