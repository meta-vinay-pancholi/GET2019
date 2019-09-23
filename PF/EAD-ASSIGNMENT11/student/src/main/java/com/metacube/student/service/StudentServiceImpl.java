package com.metacube.student.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.student.dao.StudentDao;
import com.metacube.student.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentDao studentdaoObj;

	@Override
	public void insertData(Student sObj) {
		studentdaoObj.add(sObj);
	}

	@Override
	public List<Student> getAll() {
		return studentdaoObj.getAll();
	}

	@Override
	public List<Student> duplicateEmail(Student sObj) {
		return studentdaoObj.duplicateEmail(sObj);
	}

	@Override
	public List<Student> findByID(Student student) {
		return studentdaoObj.findByID(student);
	}
}