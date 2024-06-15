package com.springproject.service;

import java.util.List;

import com.springproject.model.Department;
import com.springproject.model.Employee;

public interface EmployeeService {
	void addEmp(Employee emp);
	void deleteEmp(Long id);
	void updateEmp(Employee emp);
	Employee getDeptById(Long id);
	List<Employee> getAllEmp();

}
