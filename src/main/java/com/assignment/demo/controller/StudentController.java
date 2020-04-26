package com.assignment.demo.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.demo.exception.StudentAPIException;
import com.assignment.demo.exception.StudentMandatoryParameterMissing;
import com.assignment.demo.model.Student;
import com.assignment.demo.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	  @Autowired
	  StudentService studentService;
	
	
	
	
	//Post Mapping is used to create and Update record
		@PostMapping("/students")
		public Student createStudent(@RequestBody Student student) throws StudentAPIException, StudentMandatoryParameterMissing {
		    Student stud = studentService.createStudent(student);
		    return stud;
		}
		
	
	@GetMapping("/students")
	public List<Student> getStudent() {
		List<Student> students =studentService.getAllStudent();
		return students;
		
	}
	
	@GetMapping("/students/{name}")
	public List<Student> getStudentByName(@PathVariable("name") String name) {
		
		List<Student> students =studentService.getStudent(name);
		return students;
	}
	
	@GetMapping("/student/{id}")
	public Student getStudentByid(@PathVariable("id") UUID id) {
		Student stud;
		Optional<Student> studentbyid =studentService.getStudentByID(id);
        stud=studentbyid.get();
		return stud;
		
		
	}
	
	@DeleteMapping("/delete/Student/{id}")
	public void  deleteStudentById(@PathVariable("id") UUID id) {
			studentService.deleteStudent(id);
		
	}
	  

}
