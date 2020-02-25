package com.ncoronel.ar.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ncoronel.ar.springboot.entity.Course;
import com.ncoronel.ar.springboot.repository.CourseJpaRepository;
import com.ncoronel.ar.springboot.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService{

	
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	@Override
	public List<Course> getAll() {
		return  courseJpaRepository.findAll();
	}

	@Override
	public Course saveCourse(Course course) {
		Course courseSave =new Course();
		courseSave = courseJpaRepository.save(course);
		return courseSave;
	}

	@Override
	public Course getCourse(String name) {
		Course course =new Course();
		course=courseJpaRepository.findByName(name);
		return course;
		
	}

	@Override
	public Course updateCourse(Course course) {
		Course courseUpdate = new Course();
		courseUpdate=courseJpaRepository.save(course);
		return courseUpdate;
	}

	@Override
	public int deleteCourse(int idCourse) {
		int deleteCourse =0;
		Optional<Course> courseDelete =null;
		
		courseDelete = courseJpaRepository.findById(idCourse);
		
		if(courseDelete.isPresent()) {
			Course delete = courseDelete.get();
			courseJpaRepository.delete(delete);
			deleteCourse=1;
		}
		return deleteCourse;
		
	}

	
	
}
