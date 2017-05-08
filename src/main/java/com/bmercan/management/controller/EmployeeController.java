package com.bmercan.management.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bmercan.management.model.Employee;
import com.bmercan.management.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping
    public List<Employee> listAll() {
        return employeeService.listAllEmployees();
    }

    @RequestMapping(value = "/{cityCode}", method = RequestMethod.GET)
    public Employee get(@PathVariable Integer cityCode) {
        return employeeService.findEmployeeByName(cityCode);
    }

    @RequestMapping(value = "/{cityCode}", method = RequestMethod.POST)
    public Employee save(@PathVariable Integer cityCode, @RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @RequestMapping(value = "/{cityCode}", method = RequestMethod.PUT)
    public Employee update(@PathVariable Integer cityCode, @RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }

    @RequestMapping(value = "/{cityCode}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable Integer employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }


}
