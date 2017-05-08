package com.bmercan.management.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bmercan.management.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Serializable>{

	List<Employee> findByName(String name);
}
