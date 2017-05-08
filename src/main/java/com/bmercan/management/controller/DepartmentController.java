package com.bmercan.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bmercan.management.model.Department;
import com.bmercan.management.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

	@Autowired 
	private DepartmentService departmentService;
	
    @RequestMapping
    public List<Department> listAll() {
        return departmentService.listAllDepartments();
    }

    @RequestMapping(value = "/{departmentId}", method = RequestMethod.GET)
    public Department get(@PathVariable Integer departmentId) {
        return departmentService.findDepartmentByName(departmentId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Department save(@RequestBody Department department) {
    	return departmentService.createDepartment(department);
    }

    @RequestMapping(value = "/{departmentId}", method = RequestMethod.PUT)
    public Department update(@PathVariable Integer departmentId, @RequestBody Department department) {
        return departmentService.updateDepartment(department);
    }

    @RequestMapping(value = "/{departmentId}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable Integer departmentId) {
        return departmentService.deleteDepartment(departmentId);
    }

}
