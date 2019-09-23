package com.metacube.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.student.entity.Student;
import com.metacube.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepo;

	@Override
	public void insertData(Student studentObj) {
		studentRepo.save(studentObj);
	}

	@Override
	public List<Student> getAll() {
		return studentRepo.findAll();
	}

	@Override
	public List<Student> duplicateEmail(Student studentObj) {
		return studentRepo.findByEmailContainingIgnoreCase(studentObj.getEmail());
	}

	@Override
	public List<Student> findByID(Student studentObj) {
		return studentRepo.findByLastnameAndFirstname(studentObj.getLastname() , studentObj.getFirstname());
	}
}