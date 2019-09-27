package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Parent;

public interface ParentRepository extends CrudRepository<Parent, Integer>{

}
