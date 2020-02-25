package com.ncoronel.ar.springboot.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ncoronel.ar.springboot.dto.CourseDto;
import com.ncoronel.ar.springboot.entity.Course;
import com.ncoronel.ar.springboot.repository.CourseJpaRepository;
import com.ncoronel.ar.springboot.service.CourseService;

@Service("courseServiceImpl")
public class CourseServiceImpl implements CourseService{

	
	
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
	
	@Autowired
	@Qualifier("courseDto")
	private CourseDto courseDto;
	
	@Override
	public List<CourseDto> getAll() {
		return   courseDto.convertListCourseToCourseDto(courseJpaRepository.findAll());
	}

	@Override
	public CourseDto saveCourse(CourseDto course) {
		Course courseSave =new Course();
		courseSave = courseJpaRepository.save(courseDto.convertCourseDtoToCourse(course));
		return  courseDto.convertCourseToCourseDto(courseSave);
	}

	@Override
	public CourseDto getCourse(String name) {
		Course course =new Course();
		course=courseJpaRepository.findByName(name);
		return   courseDto.convertCourseToCourseDto(course);
		
	}

	@Override
	public CourseDto updateCourse(CourseDto course) {
		Course courseUpdate = new Course();
		courseUpdate=courseJpaRepository.save(courseDto.convertCourseDtoToCourse(course));
		return courseDto.convertCourseToCourseDto(courseUpdate) ;
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
