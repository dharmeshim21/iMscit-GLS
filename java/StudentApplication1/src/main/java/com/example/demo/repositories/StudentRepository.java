package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
}
