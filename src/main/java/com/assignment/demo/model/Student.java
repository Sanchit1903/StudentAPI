package com.assignment.demo.model;

import java.util.UUID;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table
@Getter
@Setter
public class Student {
	
	@PrimaryKey
	  private UUID id;
	  private String name;
	  private String semester;
	  private Integer age;
	  private String branch;
	  private String college;
	  
	  public Student() {

	  }


	public Student(UUID id, String name, String semester, Integer age, String branch, String college) {
		super();
		this.id = id;
		this.name = name;
		this.semester = semester;
		this.age = age;
		this.branch = branch;
		this.college = college;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", semester=" + semester + ", age=" + age + ", branch=" + branch
				+ ", college=" + college + "]";
	}
	
	

}
