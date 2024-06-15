package com.springproject.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springproject.model.Department;
import com.springproject.repository.DEpartmentRepository;
import com.springproject.service.DepartmentService;
@Service
public class DepartmentServiceImpl implements DepartmentService {
	@Autowired
private DEpartmentRepository depRepo;
	@Override
	public void addDept(Department dept) {
		depRepo.save(dept);
		
	}

	@Override
	public void deleteDept(int id) {
		depRepo.deleteById(id);
		
	}

	@Override
	public void updateDept(Department dept) {
		depRepo.save(dept);
		
	}

	@Override
	public Department getDeptById(int id) {
		// TODO Auto-generated method stub
		return depRepo.findById(id).get();
	}

	@Override
	public List<Department> getAllDepts() {
		// TODO Auto-generated method stub
		return depRepo.findAll();
	}

}
