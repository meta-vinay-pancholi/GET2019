package com.metacube.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.metacube.student.entity.Student;

@Service
public interface StudentService {
	void insertData(Student sObj);
	public List<Student> getAll();
	List<Student> duplicateEmail(Student sObj);
	List<Student> findByID(Student map);
}
