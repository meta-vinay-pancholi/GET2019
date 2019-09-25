package com.metacube.StudentHibernate.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.StudentHibernate.Dao.StudentDao;
import com.metacube.StudentHibernate.model.Student;


@SuppressWarnings("deprecation")
@Controller
public class HomeController {

	static Resource r = new ClassPathResource("applicationContext.xml");  
	public static BeanFactory factory = new XmlBeanFactory(r);  
      
    StudentDao studentDao = (StudentDao)factory.getBean("d");  
	
	@Value("${home.message}")
	private String welcomeMsg;
	
	/**
	 * Get mapping for login page
	 * @param error
	 * @param model
	 * @return
	 */
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) {
			model.addAttribute("errorMsg", "Authentication failed");
		}
		return "loginPage";
	}
	
	/**
	 * to send to home page
	 * @param model
	 * @return
	 */
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("welcomeMsg", welcomeMsg);
		return "home";
	}
	
	/**
	 * to send to signup page
	 * @param model
	 * @return
	 */
	@GetMapping("/signUp") 
	public String signUp(Model model) {
		model.addAttribute("student", new Student());
		return "signUp";
	}
	
	/**
	 * to check validations
	 * @param student
	 * @param result
	 * @return
	 */
	@PostMapping("/signUp") 
	public String doSignUp(@Validated Student student, BindingResult result, RedirectAttributes attributes, Model model) {
		if (result.hasErrors()) {
			return "signUp";
			
		} else {
			System.out.println(student);
			try {
				studentDao.saveStudent(student);
			} catch(DataIntegrityViolationException e) {
				model.addAttribute("msg", "Duplicate email id");
				return "signUp";
			}
			return "redirect:/home";	
		}
	}
	
	/**
	 * To show students
	 * @param model model object
	 * @return showStudents page
	 */
	@GetMapping("/showStudent") 
	public String showStudents(Model model) {
		List<Student> studentList = new ArrayList<Student>();
		studentList = studentDao.getStudents();
		model.addAttribute("Students", studentList);
		return "showStudents";
	}
}
