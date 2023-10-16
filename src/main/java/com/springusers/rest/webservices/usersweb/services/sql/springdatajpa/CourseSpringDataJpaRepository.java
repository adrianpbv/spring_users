package com.springusers.rest.webservices.usersweb.services.sql.springdatajpa;

import java.util.List;

import com.springusers.rest.webservices.usersweb.services.sql.Course;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long>{
	List<Course> findByAuthor(String author);
	List<Course> findByName(String name);
}