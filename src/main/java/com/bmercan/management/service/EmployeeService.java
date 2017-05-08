package com.bmercan.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmercan.management.model.Employee;
import com.bmercan.management.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public List<Employee> listAllEmployees(){
		return (List<Employee>) employeeRepository.findAll();
	}

	public Employee createEmployee(Employee employee){
		return employeeRepository.save(employee);
	}
	
	public Employee updateEmployee(Employee employee){
			Employee employee2 = employeeRepository.findOne(employee.getEmployeeId());
			
			employee2.setDepartment(employee.getDepartment());
			employee2.setName(employee.getName());
			employee2.setSalary(employee.getSalary());
			employee2.setSurname(employee2.getSurname());
			
			return employeeRepository.save(employee2);
	}
	
	public Boolean deleteEmployee(Integer employeeId){
		
		try{
			employeeRepository.delete(employeeId);
			return true;
		}catch(Exception e){
			return false;
		}
		
	}
	
	public Employee findEmployeeByName(Integer employeeId){
		return (Employee) employeeRepository.findOne(employeeId);
	}
}
