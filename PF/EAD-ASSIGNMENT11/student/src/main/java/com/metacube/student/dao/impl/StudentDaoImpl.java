package com.metacube.student.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.metacube.student.dao.StudentDao;
import com.metacube.student.entity.Student;

@Transactional
@Component
public class StudentDaoImpl implements StudentDao {

	@Autowired
	HibernateTemplate template;
	
	public StudentDaoImpl() {
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public int add(Student sObj) {
		return (int) template.save(sObj);
	}

	@Override
	public List<Student> duplicateEmail(Student sObj) {
		return template.findByExample(sObj);
	}

	@Override
	public List<Student> getAll() {
		return template.loadAll(Student.class);
	}

	@Override
	public List<Student> findByID(Student student) {
		return template.findByExample(student);
	}
}