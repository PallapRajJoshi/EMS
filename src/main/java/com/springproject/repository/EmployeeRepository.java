package com.springproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springproject.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	

}
