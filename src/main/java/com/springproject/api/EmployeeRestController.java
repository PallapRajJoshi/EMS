package com.springproject.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springproject.model.Employee;
import com.springproject.model.Product;
import com.springproject.repository.ProductRepositary;
import com.springproject.service.EmployeeService;

@RestController

public class EmployeeRestController {
	@Autowired
	private ProductRepositary pripo;
	@Autowired
	private EmployeeService is;
	@GetMapping("/api/emp/list")
public List<Employee> getAll() {
	return is.getAllEmp();
}
	
	@GetMapping("/api/emp/{id}")
	public Employee getOne(@PathVariable Long id) {
		
		return is.getDeptById(id);
	}
	
	
	@PostMapping("/api/emp/add")
	public String addEMP(@RequestBody Employee emp) {
		
		is.addEmp(emp);
		return "success";
	}

//Useeee
@GetMapping("/api/emp/j20")
public String jsonTOObjecto() {
	
	
	
	RestTemplate temp=new RestTemplate();
	Employee emp=temp.getForObject("http://localhost:1111/api/emp/3", Employee.class);
	return"Firstname="+emp.getFname();
	
}


@GetMapping("/api/emp/ja2oa")
public String jsonArrayToObjectArray() {
	
	RestTemplate temp=new RestTemplate();
	Employee[] emp=temp.getForObject("http://localhost:1111/api/emp/list", Employee[].class);
	
	
	return"Company="+emp[0].getCompany();
}



@GetMapping("/api/products")
public String loadProducts() {
	
	RestTemplate temp=new RestTemplate();
	Product[] p=temp.getForObject("https://fakestoreapi.com/products", Product[].class);
	pripo.saveAll(List.of(p));
	return"Success";
}
}