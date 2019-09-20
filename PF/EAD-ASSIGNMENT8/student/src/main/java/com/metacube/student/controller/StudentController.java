package com.metacube.student.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.metacube.student.model.Student;

@Controller
public class StudentController {
	List<Student> studentlist = new ArrayList<Student>();
	@Value("${welcome.message}")
	private String message;

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("message", message);
		return "homepage";
	}

	@GetMapping("/addStudent")
	public String addStudent(Model model) {
		model.addAttribute(new Student());
		return "addStudent";
	}

	@PostMapping("/addStudent")
	public String doSignup(@Valid @ModelAttribute("student") Student student,
			BindingResult result) {
		if (result.hasErrors()) {
			return "addStudent";
		} else {
			studentlist.add(student);
			return "redirect:/home";
		}
	}

	@GetMapping("/showAllStudent")
	public String showStudent(Model model) {
		model.addAttribute("studentlist", studentlist);
		return "showAllStudent";
	}
}
