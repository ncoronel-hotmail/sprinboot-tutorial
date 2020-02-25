package com.ncoronel.ar.springboot.service;

import java.util.List;

import com.ncoronel.ar.springboot.dto.CourseDto;

public interface CourseService {
	
	public abstract List<CourseDto> getAll();
	public abstract CourseDto saveCourse(CourseDto course);
	public abstract CourseDto getCourse(String name);
	public abstract CourseDto updateCourse(CourseDto course);
	public abstract int deleteCourse(int idCourse);



}
