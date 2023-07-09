package com.map1;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Employee {

	@Id
	private int EmpolyeeID;

	@Column(name = "Employee_name")
	private String EmployeeName;

	@ManyToMany
	private List<Project> projects;

	public int getEmpolyeeID() {
		return EmpolyeeID;
	}

	public void setEmpolyeeID(int empolyeeID) {
		EmpolyeeID = empolyeeID;
	}

	public String getEmployeeName() {
		return EmployeeName;
	}

	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Employee(int empolyeeID, String employeeName, List<Project> projects) {
		super();
		EmpolyeeID = empolyeeID;
		EmployeeName = employeeName;
		this.projects = projects;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
