package com.metacube.student.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.metacube.student.entity.Student;

@Repository
public interface StudentDao {

	public int add(Student sObj);
	public List<Student> duplicateEmail(Student sObj);
	public List<Student> getAll();
	public List<Student> findByID(Student student);
}
