package com.assignment.demo.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.assignment.demo.exception.StudentAPIException;
import com.assignment.demo.exception.StudentMandatoryParameterMissing;
import com.assignment.demo.exception.StudentNotFoundException;
import com.assignment.demo.model.Student;
import com.assignment.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;

	public List<Student> getStudent(String name) {
		List<Student> students = studentRepository.findByName(name);
		if (students.isEmpty()) {
			throw new StudentNotFoundException("Student Not Found");
		}

		return students;
	}

	public Student createStudent(Student student) throws StudentAPIException, StudentMandatoryParameterMissing {
		studentMissingParameter(student, stud -> stud.getName().trim().isEmpty());

		try {
			List<Student> students = studentRepository.findByName(student.getName());
			students = students.stream().filter(stud -> stud.getId().equals(student.getId()))
					.collect(Collectors.toList());
			if (students.isEmpty()) {
				UUID id = UUID.randomUUID();
				student.setId(id);
			}
			Student stud = studentRepository.save(student);
			return stud;
		} catch (Exception e) {
			throw new StudentAPIException("RuntimeException");
		}
	}

	// Method using lambda operation
	public void studentMissingParameter(Student student, Predicate<Student> predicate)
			throws StudentMandatoryParameterMissing {
		if (predicate.test(student)) {
			throw new StudentMandatoryParameterMissing("Mandatory Parameter Missing");
		}

	}

	public List<Student> getAllStudent() {
		List<Student> students = studentRepository.findAll();
		if (students.isEmpty()) {
			throw new StudentNotFoundException("Student Not Found");
		}
		return students;

	}

	public Optional<Student> getStudentByID(UUID id) {
		Optional<Student> studentbyid = studentRepository.findById(id);
		if (!studentbyid.isPresent()) {
			throw new StudentNotFoundException("Student Not Found By id");
		}
		return studentbyid;

	}

	public void deleteStudent(UUID id) {
		Optional<Student> delStud = studentRepository.findById(id);
		if (delStud.isPresent()) {
			Student student = delStud.get();
			studentRepository.delete(student);
		} else {
			throw new StudentNotFoundException("Student Not Found By id");
		}

	}
}
