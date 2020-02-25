package com.ncoronel.ar.springboot.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ncoronel.ar.springboot.entity.Course;

@Component("courseDto")
public class CourseDto {

	private int id;

	private String name;

	private String description;

	private int price;

	private int hours;

	public CourseDto() {
		super();
	}

	public CourseDto(int id, String name, String description, int price, int hours) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.hours = hours;
	}

	public CourseDto(String name, String description, int price, int hours) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.hours = hours;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public CourseDto convertCourseToCourseDto(Course course) {
		CourseDto courseDto = new CourseDto();
		courseDto.setId(course.getId());
		courseDto.setName(course.getName());
		courseDto.setDescription(course.getDescription());
		courseDto.setPrice(course.getPrice());
		courseDto.setHours(course.getHours());

		return courseDto;
	}

	public Course convertCourseDtoToCourse(CourseDto courseDto) {
		Course course = new Course();
		course.setId(courseDto.getId());
		course.setName(courseDto.getName());
		course.setDescription(courseDto.getDescription());
		course.setPrice(courseDto.getPrice());
		course.setHours(courseDto.getHours());

		return course;
	}
	
	
	public List<CourseDto> convertListCourseToCourseDto(List<Course> course) {
		List <CourseDto> lstCourseDto = new ArrayList<CourseDto>();
		
		for (Course courseObject : course) {
			CourseDto courseDto = new CourseDto();
			courseDto.setId(courseObject.getId());
			courseDto.setName(courseObject.getName());
			courseDto.setDescription(courseObject.getDescription());
			courseDto.setPrice(courseObject.getPrice());
			courseDto.setHours(courseObject.getHours());
			lstCourseDto.add(courseDto);
			
		}
		
		
		return lstCourseDto;
	}
	
	
	
}
