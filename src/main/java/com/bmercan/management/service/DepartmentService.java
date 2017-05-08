package com.bmercan.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmercan.management.model.Department;
import com.bmercan.management.repository.DepartmentRepository;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<Department> listAllDepartments(){
		return (List<Department>) departmentRepository.findAll();
	}

	public Department createDepartment(Department department){
		
		return departmentRepository.save(department);
	}
	
	public Department updateDepartment(Department department){
		Department department2 = departmentRepository.findOne(department.getDepartmentId());
			
			department2.setDepartmentName(department.getDepartmentName());
			department2.setDepartmentDescription(department.getDepartmentDescription());
			department2.setEmployeeList(department.getEmployeeList());
			
			return departmentRepository.save(department2);
	}
	
	public Boolean deleteDepartment(Integer departmentId){
		
		try{
			departmentRepository.delete(departmentId);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
	
	public Department findDepartmentByName(Integer departmentId){
		return (Department) departmentRepository.findOne(departmentId);
	}
	
}
