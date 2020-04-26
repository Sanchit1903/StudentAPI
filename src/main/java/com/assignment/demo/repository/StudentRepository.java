package com.assignment.demo.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import com.assignment.demo.model.Student;

public interface StudentRepository extends CassandraRepository<Student, UUID> {
	
	@AllowFiltering
	List<Student> findByName(String name);
	
}
