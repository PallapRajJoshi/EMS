package com.springproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.springproject.model.Employee;
import com.springproject.repository.EmployeeRepository;
import com.springproject.service.EmployeeService;
@Service
public class EmployeeServiceImp implements EmployeeService {
@Autowired
private EmployeeRepository empRepo;
	@Override
	public void addEmp(Employee emp) {
	empRepo.save(emp);
		
	}

	@Override
	public void deleteEmp(Long id) {
		empRepo.deleteById( id);
		
	}

	@Override
	public void updateEmp(Employee emp) {
		empRepo.save(emp);
		
	}

	@Override
	public Employee getDeptById(Long id) {
		// TODO Auto-generated method stub
		return empRepo.findById(id).get();
	}

	@Override
	public List<Employee> getAllEmp() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

}
