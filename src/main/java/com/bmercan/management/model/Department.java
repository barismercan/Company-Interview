package com.bmercan.management.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="Department")
public class Department implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 4689453829326243636L;

	@Id
    @Column(name = "department_id")
    @GeneratedValue
    private Integer departmentId;

    @Column(name="department_name")
    private String departmentName;

    @Column(name = "department_description")
    private String departmentDescription;
    
    @OneToMany(mappedBy="department",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JsonManagedReference
    private List<Employee> employeeList;
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department city = (Department) o;

        if (departmentId != null ? !departmentId.equals(city.departmentId) : city.departmentId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return departmentId != null ? departmentId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + ", departmentDesc=" + departmentDescription +
                '}';
    }

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentDescription() {
		return departmentDescription;
	}

	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
}
