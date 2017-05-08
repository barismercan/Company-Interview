package com.bmercan.management.repository;

import org.springframework.data.repository.CrudRepository;

import com.bmercan.management.model.Department;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {

    List<Department> findByDepartmentName(String name);

}
