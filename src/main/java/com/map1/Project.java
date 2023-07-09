package com.map1;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	private int ProjectID;

	@Column(name = "project_name")
	private String projectName;

	@ManyToMany(mappedBy = "projects")
	private List<Employee> employees;

	public int getProjectID() {
		return ProjectID;
	}

	public void setProjectID(int projectID) {
		ProjectID = projectID;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Project(int projectID, String projectName, List<Employee> employees) {
		super();
		ProjectID = projectID;
		this.projectName = projectName;
		this.employees = employees;
	}

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

}
