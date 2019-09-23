package com.metacube.student.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.student.dto.SearchStudentDTO;
import com.metacube.student.dto.StudentDto;
import com.metacube.student.entity.Student;
import com.metacube.student.service.StudentService;
import com.metacube.student.util.DtoUtil;

@Controller
public class StudentController {
	List<Student> studentlist = new ArrayList<Student>();

	@Autowired
	private StudentService studentObj;

	@Value("${home.message}")
	private String message;

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("message", message);
		return "homepage";
	}

	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		model.addAttribute("student", new StudentDto());
		return "addStudent";
	}

	@PostMapping("/addStudent")
	public String doSignupByPost(
			@ModelAttribute("student") @Validated StudentDto student,
			BindingResult errorResult, Model model) {
		if (errorResult.hasErrors()) {
			ObjectError oe = new ObjectError("Email", "Fill The Form");
			errorResult.addError(oe);
			return "addStudent";
		} else {
			List<Student> studentData = studentObj.duplicateEmail(DtoUtil.map(
					student, Student.class));
			if (studentData.size() > 0) {

				model.addAttribute("success", "Student Email Exit");
				return "addStudent";
			}
			studentObj.insertData(DtoUtil.map(student, Student.class));
			model.addAttribute("success", "Student Add Successfully");
			return "homepage";
		}
	}

	@GetMapping("/showAllStudent")
	public String showStudent(Model model, StudentDto student) {
		List<Student> studentData = studentObj.getAll();
		model.addAttribute("studentlist", studentData);
		return "showAllStudent";
	}

	@GetMapping("/search")
	public String searchStudentByGet(Model model) {
		model.addAttribute("SearchCommand", new SearchStudentDTO());
		return "search";
	}

	@PostMapping("/search")
	public String searchStudentByPost(
			@ModelAttribute("SearchCommand") @Validated SearchStudentDTO student,
			BindingResult errorResult, Model model) {
		List<Student> studentData = studentObj.findByID(DtoUtil.map(student,
				Student.class));
		if (studentData.size() > 0) {
			System.out.println(studentData.get(0).getEmail());
			model.addAttribute("studentData", studentData);
			return "search";
		}
		model.addAttribute("success", "No Student Found");
		return "search";
	}
}