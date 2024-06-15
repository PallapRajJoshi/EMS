package com.springproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springproject.model.Employee;
import com.springproject.service.DepartmentService;
import com.springproject.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService empSer;
	@Autowired
	private DepartmentService dptService;

	@GetMapping("/addemployee")
	public String getEmp(Model m) {

		m.addAttribute("dlist", dptService.getAllDepts());
		return "EmployeeForm";
	}

	
	@PostMapping("/employee")
	public String postEmp(@ModelAttribute Employee emp, Model m) {

		empSer.addEmp(emp);
		m.addAttribute("messageSuccess", "Employee Added");

		return "redirect:/addemployee";
	}
	
	//employee list controlling
	@GetMapping("/employeeList")
	public String getEmployee(@ModelAttribute Employee e,Model m) {
		m.addAttribute("empList", empSer.getAllEmp());
		return "EmployeeList";
	}
	
	@GetMapping("/emp/delete")
	public String deleteEmployee(@RequestParam long id) {
		empSer.deleteEmp(id);
		return "redirect:/employeeList";
	}

}
