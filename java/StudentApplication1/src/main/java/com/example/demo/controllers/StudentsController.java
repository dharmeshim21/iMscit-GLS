package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StudentsController {
	@Autowired
	StudentRepository students;
	
	@PostMapping("/register")
	public String addStudent(Student student) {
		try {
			students.save(student);
			return "done";
		}
		catch (Exception e) {
			return e.getMessage();
		}
	}
}
