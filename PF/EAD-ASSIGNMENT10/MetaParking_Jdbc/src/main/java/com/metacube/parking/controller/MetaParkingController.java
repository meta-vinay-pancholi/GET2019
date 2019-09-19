package com.metacube.parking.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.metacube.parking.dto.EditProfile;
import com.metacube.parking.model.Employee;
import com.metacube.parking.model.EmployeeFriend;
import com.metacube.parking.model.EmployeeLogin;
import com.metacube.parking.model.Pass;
import com.metacube.parking.model.VehicleDetails;
import com.metacube.parking.service.ParkingService;
import com.metacube.parking.service.impl.ParkingServiceImpl;
import com.metacube.parking.util.DtoUtil;

@Controller()
public class MetaParkingController {
	List<Employee> emplist = new ArrayList<Employee>();
	List<EmployeeLogin> login = new ArrayList<EmployeeLogin>();
	List<VehicleDetails> vehicleDetails = new ArrayList<VehicleDetails>();
	@Autowired
	ParkingServiceImpl parkingServiceobj;
	

	Integer[] passPrices = null;

	@GetMapping("/home")
	public String home(Model model,HttpServletRequest req) {
		HttpSession session=req.getSession(true);
		if(session.getAttribute("email") != null) {
			return "redirect:/showProfile";
		}
		model.addAttribute("employeeLogin", new EmployeeLogin());
		return "homepage";
	}

	@PostMapping("/home")
	public String loginAuth(@ModelAttribute("employeeLogin") @Validated  EmployeeLogin  employee , BindingResult errorResult , Model model , HttpServletRequest req , RedirectAttributes redirectAttributes) {
		
		if(errorResult.hasErrors()) {
			return "homepage";
		} else {
			try {
				Employee employeeData = parkingServiceobj.getAllData(employee.getEmail(), employee.getPassword());
				if(employeeData != null) {
					HttpSession session=req.getSession(true);
					session.setAttribute("email", employeeData.getEmail());
					session.setAttribute("id", employeeData.getId());
					return "redirect:/showProfile";
				} else {
					ObjectError oe = new ObjectError("authenticatedFailed", "Wrong id and password");
					errorResult.addError(oe);
					return "homepage";
				}
			} catch(EmptyResultDataAccessException e) { 
				ObjectError oe = new ObjectError("authenticatedFailed", "Email Not  find Please Sign Up First");
				errorResult.addError(oe);
				return "homepage";

			} catch (Exception e) {
				System.out.println(e);
				ObjectError oe1 = new ObjectError("authenticatedFailed", "Something went wrong please try after some time");
				errorResult.addError(oe1);
				return "homepage";
			}
		}
	
	}
	

	@GetMapping("/signUp")
	public String registerPage(Model model , HttpServletRequest req) {
		HttpSession session=req.getSession(true);
		if(session.getAttribute("email") != null) {
			return "redirect:/showProfile";
		}
		model.addAttribute("employee", new Employee());
		return "signUp";
	}

	@PostMapping("/signUp")
	public String userRegisterAuthentication(
			@ModelAttribute("employee") @Validated Employee employee,
			BindingResult errorResult, Model model, HttpServletRequest req , RedirectAttributes redicAttributes) {
		if (errorResult.hasErrors()||!(employee.getPassword().equals(employee.getConfirmPassword()))) {
			return "signUp";
		} else {
			String email = employee.getEmail();
			String name = employee.getFullname();
			try {
					parkingServiceobj.addEmployee(DtoUtil.map(employee, Employee.class));
					HttpSession session = req.getSession(false);
					session.setAttribute("email", email);
					redicAttributes.addFlashAttribute("AccountCreated", "Welcome "+name+" Your Account is Created Succefully");
					return "redirect:/vehicleRegistration";
				
				
				
			} catch (DuplicateKeyException e) {
				model.addAttribute("duplicateEmail", "email already Used");
				return "signUp";
			} catch(Exception e) {
				model.addAttribute("sqlException", e);
				return "signUp";
			}
		}

	}

	@GetMapping("/vehicleRegistration")
	public String vehicleRegister(Model model , HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		model.addAttribute("vehicle", new VehicleDetails());
		if(session.getAttribute("email") != null) {
			model.addAttribute("vehicle", new VehicleDetails());
			model.addAttribute("url",1);
			try {
				Employee employeeData = parkingServiceobj.getDataByEmail(String.valueOf(session.getAttribute("email")));
				model.addAttribute("employeeId" , employeeData.getId());
				session.setAttribute("id", employeeData.getId());
			} catch (Exception e) {
				return "vehicleRegistration";
			}
		}
		return "vehicleRegistration";
	}
	
	@PostMapping("/vehicleRegistration")
	public String vechileRegister(@ModelAttribute("vehicle") @Validated  VehicleDetails  vehicle , BindingResult result , Model model , HttpServletRequest req , RedirectAttributes flashAttributes) {
		if(result.hasErrors()) {
			return "vehicleRegistration";
		} else {
			try {
				HttpSession session = req.getSession(false);
					boolean query = parkingServiceobj.addEmployeeVechile(DtoUtil.map(vehicle, VehicleDetails.class));
					if(query) {
						model.addAttribute("Success" ,"Vehicle Register Succefully");
						flashAttributes.addAttribute("type", vehicle.getVehicleType());
						return "redirect:/getPass";
					}
				}
			 catch (DuplicateKeyException e) {
				model.addAttribute("duplicateNumber", "Vehicle already Register");
			} catch (Exception e) {
				System.out.println(e);
				return "vehicleRegistration";
			}
			return "vehicleRegistration"; 
		}
	
	}
	@GetMapping("/getPass")
	public String getPass(@RequestParam("type") String type, Model model) {
		if ("cycle".equals(type)) {
			passPrices = new Integer[] { 5, 100, 500 };
		} else if ("bike".equals(type)) {
			passPrices = new Integer[] { 10, 200, 1000 };
		} else if ("car".equals(type)) {
			passPrices = new Integer[] { 20, 500, 3500 };
		}
		Map<Integer, String> passMap = new HashMap<Integer, String>();
		passMap.put(passPrices[0], passPrices[0] + "Daily");
		passMap.put(passPrices[1], passPrices[1] + "Monthly");
		passMap.put(passPrices[2], passPrices[2] + "Yearly");
		model.addAttribute("passPrices", passMap);
		model.addAttribute("pass", new Pass());
		return "getPass";
	}

	@PostMapping("/getPass")
	public String getFinalPass(@Validated Pass pass, BindingResult result,
			RedirectAttributes reAttribute) {
		double plan = Double.parseDouble(pass.getPlan());
		String currency = pass.getCurrency();
		if ("YEN".equals(currency)) {
			plan = plan * 1.49;
		} else if ("USD".equals(currency)) {
			plan = plan * 0.014;
		}
		reAttribute.addAttribute("passPrice", plan);
		return "redirect:/pass";
	}

	@GetMapping("/showProfile")
	public String getUserProfile(Model model , HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		System.out.println(session.getAttribute("email")+"email");
		if(session.getAttribute("email") != null  && session.getAttribute("id")!=null) {
			model.addAttribute("url", 3);
			try {
				Employee employeeData = parkingServiceobj.getDataById(String.valueOf(session.getAttribute("id")));
				model.addAttribute("EmployeeDetails" , employeeData);
			} catch (Exception e) {
				return "rediret:/home";
			}
		}
		return "showProfile";
	}
	
	@PostMapping("/showProfile")
	public String update(Model model, Employee emp) {
		return "redirect:/update";
	}

	@GetMapping("/update")
	public String update(Model model,HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		Employee employeeData = parkingServiceobj.getDataById(String.valueOf(session.getAttribute("id")));
		model.addAttribute("EmployeeDetails", employeeData);
		return "update";
	}
//
//	@PostMapping("/update")
//	public String updateEmployee(@Validated Employee employee,
//			BindingResult result, RedirectAttributes attributes) {
//		if (result.hasErrors()) {
//			return "update";
//		} else {
//			if (!(employee.getPassword().equals(employee.getConfirmPassword()))) {
//				ObjectError error = new ObjectError("errorMsg",
//						"Password and confirm password should be same");
//				result.addError(error);
//			}
//			for (Employee emp : emplist) {
//				if (emp.getEmail().equals(employee.getEmail())) {
//					emp.setFullname(employee.getFullname());
//					emp.setContact(employee.getContact());
//					emp.setGender(employee.getGender());
//					emp.setOrganisation(employee.getOrganisation());
//					emp.setEmail(employee.getEmail());
//					emp.setPassword(employee.getPassword());
//					emp.setConfirmPassword(employee.getConfirmPassword());
//				}
//			}
//			return "home";
//		}
//	}

	@PostMapping("/update")
	public String updateEditProfile(@ModelAttribute("EmployeeDetails") @Validated  EditProfile employee , BindingResult errorResult , Model model , MultipartFile file ,HttpServletRequest req) throws IOException {
		 String fileName = "user.png";
		 HttpSession session = req.getSession(false);
		 String id = String.valueOf(session.getAttribute("id"));
		if(errorResult.hasErrors()){
			return "update";
		} else {
			if(!employee.getProfile().isEmpty()){
				 MultipartFile multipartFile = employee.getProfile();
		         String uploadPath = "C:/Users/Vinay/Documents/workspace-sts-3.6.1.RELEASE/MetaParking_Jdbc/src/main/resources/static/img/"+employee.getProfile().getOriginalFilename();
		         //Now do something with file...
		         FileCopyUtils.copy( employee.getProfile().getBytes(), new File(uploadPath));
		         fileName = multipartFile.getOriginalFilename();
			} 
			System.out.println(fileName);
			boolean result = parkingServiceobj.updateEmployeeData(fileName,
					employee.getPassword(),
					employee.getOrganisation(),
					employee.getContact(), employee.getFullname() ,id);
			return "redirect:/showProfile";
		}
		
	}

	@GetMapping("/pass")
	public String pass(@RequestParam("passPrice") double passPrice, Model model) {
		model.addAttribute("passPrice", passPrice);
		return "pass";
	}

//	@GetMapping("/friends")
//	public String friends(@RequestParam("email") String email, Model model) {
//		List<Employee> friends = new ArrayList<Employee>();
//		String organization = null;
//		for (Employee e : emplist) {
//			if (e.getEmail().equals(email)) {
//				organization = e.getOrganisation();
//			}
//		}
//
//		for (Employee e : emplist) {
//			if (e.getOrganisation().equals(organization)
//					&& (!e.getEmail().equals(email))) {
//				friends.add(e);
//			}
//		}
//		model.addAttribute("friends", friends);
//		return "friends";
//	}
	@GetMapping("/friends")
	public String getFriendList(Model model , HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		String email = String.valueOf(session.getAttribute("email"));
		if(email!=null){
			ArrayList<EmployeeFriend> employeeFriendData = parkingServiceobj.getEmployeeFriendList(email);
			model.addAttribute("EmployeeFriend" , employeeFriendData);
			model.addAttribute("url", 2);
		}
		return "friends";
	}
	
	@GetMapping("/friendProfile/{id}")
	public String getFriendProfile(Model model , @PathVariable("id") String id) {
		boolean result = parkingServiceobj.validatePathId(id);
		if(result){
			EmployeeFriend employeeFriendData = parkingServiceobj.getEmployeeFriendListById(id);
			model.addAttribute("ProfileImformation",employeeFriendData);
			return "friendProfile";
		} else {
			return "redirect:/friends";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req) {
		HttpSession session=req.getSession(false);
		if(session.getAttribute("email") != null) {
			session.removeAttribute("email");
			session.removeAttribute("id");
		} 
		return "redirect:/home";
	}
}
