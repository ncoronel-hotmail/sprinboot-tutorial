package com.ncoronel.ar.springboot.service;

import java.util.List;

import com.ncoronel.ar.springboot.entity.Course;

public interface CourseService {
	
	public abstract List<Course> getAll();
	public abstract Course saveCourse(Course course);
	public abstract Course getCourse(String name);
	public abstract Course updateCourse(Course course);
	public abstract int deleteCourse(int idCourse);



}
