package com.springusers.rest.webservices.usersweb.services.sql;

import com.springusers.rest.webservices.usersweb.services.sql.springdatajpa.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner{

//	@Autowired
//	private CourseJdbcRepository repository;

//	@Autowired
//	private CourseJpaRepository repository;

	@Autowired
	private CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		// This code runs at app startup when initializing this component
		repository.save(new Course(1, "Learn AWS Jpa!", "in28minutes"));
		repository.save(new Course(2, "Learn Azure Jpa!", "in28minutes"));
		repository.save(new Course(3, "Learn DevOps Jpa!", "in28minutes"));
		
		repository.deleteById(1l);
		
		System.out.println(repository.findById(2l));
		System.out.println(repository.findById(3l));
		
		System.out.println(repository.findAll());
		System.out.println(repository.count());
		
		System.out.println(repository.findByAuthor("in28minutes"));
		System.out.println(repository.findByAuthor(""));

		System.out.println(repository.findByName("Learn AWS Jpa!"));
		System.out.println(repository.findByName("Learn DevOps Jpa!"));
	}

}