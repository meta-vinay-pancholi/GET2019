package com.metacube.StudentHibernate.Dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.StudentHibernate.model.Student;

/**
 * Dao class for student to perform operations on database
 * @author vinay
 *
 */
public class StudentDao {

	HibernateTemplate template;
	
	/**
	 * to initialize hibernate template
	 * @param template
	 */
	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}
	
	/**
	 * to insert an student
	 * @param stu student object
	 */
	@Transactional(readOnly = false)
	public void saveStudent(Student stu) {
		template.save(stu);
	}
	
	/**
	 * to get list of students
	 * @return students list
	 */
	@Transactional
	public List<Student> getStudents() {
		List<Student> studentList = new ArrayList<Student>();
		studentList = template.loadAll(Student.class);
		return studentList;
				
	}
}
