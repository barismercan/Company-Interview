package com.bmercan.management.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="Employee")
public class Employee implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2735655414993223529L;

	@Id
	@GeneratedValue
	@Column(name ="employee_id")
	private Integer employeeId;
	
	@Column(name="name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "salary")
	private Double salary;
	
	@ManyToOne
	@JoinColumn(name="department_id",nullable=false)
	@JsonBackReference
	private Department department;

	public Employee() {
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (getEmployeeId() != null ? !getEmployeeId().equals(employee.getEmployeeId()) : employee.getEmployeeId() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return getEmployeeId() != null ? getEmployeeId().hashCode() : 0;
    }

	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
}
