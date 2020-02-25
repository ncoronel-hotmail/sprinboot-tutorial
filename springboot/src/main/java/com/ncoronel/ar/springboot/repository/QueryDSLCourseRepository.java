package com.ncoronel.ar.springboot.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ncoronel.ar.springboot.entity.Course;
import com.ncoronel.ar.springboot.entity.QCourse;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

@Repository("queryDslCourseRepository")
public class QueryDSLCourseRepository {

	private QCourse qCourse = QCourse.course;
	
	@PersistenceContext
	private EntityManager entityManager;
	
	
	public List<Course> getCourseMInPrice(int price){
		
		JPAQuery<Course> query = new JPAQuery<Course>(entityManager);
		
		 List<Course> lstCourse= query.select(qCourse).from(qCourse).where(qCourse.price.between(0, price)).fetch();
	     return lstCourse;
	}
	
	
		public List<Course> getCourseLikeName(String name,int price){
		
		JPAQuery<Course> query = new JPAQuery<Course>(entityManager);
		
		 List<Course> lstCourse= query.select(qCourse).from(qCourse).where(qCourse.name.like(name).and(qCourse.price.gt(price))).fetch();
		  return lstCourse;
		}
	
		
		public List<Course> getCourseContainsName(String name){
			
			JPAQuery<Course> query = new JPAQuery<Course>(entityManager);
			
			 List<Course> lstCourse= query.select(qCourse).from(qCourse).where(qCourse.name.contains(name)).fetch();
			  return lstCourse;
			}
	
		
		public Long countTuplesCourse() {
			JPAQuery<Course> query = new JPAQuery<Course>(entityManager);
			
			Long count= query.select(qCourse).from(qCourse).fetchCount();
			  return count;
		}
		
		
		public List<Course> getCourseHours(int hours){
			
			JPAQuery<Course> query = new JPAQuery<Course>(entityManager);
			
			Predicate predicate = qCourse.description.contains("java");
			
			BooleanBuilder booleanBuilder = new BooleanBuilder(predicate);
			if(hours>4) {
				Predicate predicate1 = qCourse.price.lt(11);
				booleanBuilder.and(predicate1);
			}else {
				Predicate predicate2 = qCourse.price.gt(11);
				booleanBuilder.and(predicate2);

			}
			
			 List<Course> lstCourse= query.select(qCourse).from(qCourse).where(booleanBuilder).fetch();
			  return lstCourse;
			}
		
		
		
	
}
