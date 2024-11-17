package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.Student;
import com.example.demo.repositories.StudentRepository;





@Controller
public class StudentController {
	
	@Autowired
	StudentRepository students;
	
	@GetMapping("/")
	public String addStudent() {
		return "index";
	}
	
	@PostMapping("/storedata")
	public String addStudent(Student student) {
		//TODO: process POST request
		
		students.save(student);
		
		return "redirect:/students/display";
	}
	
	@GetMapping("/students/display")
	public String display(Model model) {
		List<Student> studentlist = (List<Student>)students.findAll();
		model.addAttribute("students",studentlist);	

		return "display";
	}
	
	@GetMapping("/students/delete/{id}")
	public String deleteById(@PathVariable Integer id) {
		students.deleteById(id);
		return "redirect:/students/display";
	}
	
	@GetMapping("/students/update/{id}")
	public String updateBook(@PathVariable Integer id, Model model) {
		Student student = students.findById(id).get();
		
		model.addAttribute("student",student);
		return "update";
	}
	
	@PostMapping("/updatedata")
	public String UpdateBook(Student student) {
		
		Integer id = student.getId();
		String firstName = student.getFirstName();
		String lastName = student.getLastName();
		String email = student.getEmail();
		String phone = student.getPhone();
		String course = student.getCourse();
		String gender = student.getGender();
	
		Student studentdb = students.findById(id).get();

		studentdb.setFirstName(firstName);
		studentdb.setLastName(lastName);
		studentdb.setEmail(email);
		studentdb.setPhone(phone);
		studentdb.setCourse(course);
		studentdb.setGender(gender);

		return "redirect:/students/display";

	}
	
}
