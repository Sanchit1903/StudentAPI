package com.assignment.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.assignment.demo.controller.StudentController;
import com.assignment.demo.exception.StudentAPIException;
import com.assignment.demo.exception.StudentMandatoryParameterMissing;
import com.assignment.demo.model.Student;

@SpringBootTest
class DemoApplicationTests {
	
	@Autowired
	StudentController studentcontroller;
	
	@Test
	public void StudentControllerTest() throws StudentAPIException, StudentMandatoryParameterMissing {
		  Student sample = sampleStudent();
		  studentcontroller.createStudent(sample);
		  List<Student> studbyname=studentcontroller.getStudentByName(sample.getName());
		  System.out.println("studbyname"+ studbyname);
		  List<Student> allstudent=studentcontroller.getStudent();
		  System.out.println("allstudent"+ allstudent);
		  Student testStudent =studentcontroller.getStudentByid(sample.getId());
		  System.out.println("testStudent"+ testStudent);
		  studentcontroller.deleteStudentById(sample.getId());
		  List<Student> allstudentnew=studentcontroller.getStudent();
		  System.out.println("allstudentnew"+ allstudentnew);
		  
		 }
	
	
	
	
		 private Student sampleStudent() {
			 Student student = new Student();
			 student.setName("San");
			 student.setAge(26);
			 student.setBranch("Telecomm");
			 student.setCollege("PESIT");
			 student.setSemester("2nd");
			 
		return student;
	}


}
