package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="class_room")
public class ClassRoom {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String teacherInCharge;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacherInCharge() {
		return teacherInCharge;
	}
	public void setTeacherInCharge(String teacherInCharge) {
		this.teacherInCharge = teacherInCharge;
	}
	@Override
	public String toString() {
		return "ClassRoom [id=" + id + ", name=" + name + ", teacherInCharge=" + teacherInCharge + "]";
	}
	
	
	
}
