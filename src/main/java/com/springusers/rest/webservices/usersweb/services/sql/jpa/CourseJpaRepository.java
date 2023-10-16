package com.springusers.rest.webservices.usersweb.services.sql.jpa;

import com.springusers.rest.webservices.usersweb.services.sql.Course;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional // IMPORTANT to EntityManager
public class CourseJpaRepository {
	
	@PersistenceContext // recommended
	private EntityManager entityManager; // entityManager to make operations with entities
	
	public void insert(Course course) {
		entityManager.merge(course);
	}
	
	public Course findById(long id) {
		return entityManager.find(Course.class, id);
	}

	public void deleteById(long id) {
		Course course = entityManager.find(Course.class, id);
		entityManager.remove(course);
	}

}