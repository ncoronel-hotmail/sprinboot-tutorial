package com.ncoronel.ar.springboot.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ncoronel.ar.springboot.entity.Course;

@Repository("courseJpaRepository")
public interface CourseJpaRepository extends JpaRepository<Course, Serializable> {
	
	
	//metodo que podemos crear para realizar query siguiendo la estructura de jpa repository
	// findBy nombre de un campo en mayuscula, se puede usar and, or etc
	
	public abstract Course findByPrice(int price);
	public abstract Course findByNameAndPrice(String name,int price);
	public abstract Course findByName(String namee);
	public abstract List<Course> findByNameOrderByHours(String name);

}
