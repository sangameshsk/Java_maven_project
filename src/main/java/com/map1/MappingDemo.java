package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MappingDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Employee employee1 = new Employee();
		Employee employee2 = new Employee();
		Employee employee3 = new Employee();

		employee1.setEmpolyeeID(1);
		employee1.setEmployeeName("Prateik");

		employee2.setEmpolyeeID(2);
		employee2.setEmployeeName("Sangamesh");

		employee3.setEmpolyeeID(3);
		employee3.setEmployeeName("Kumar");

		Project project1 = new Project();
		Project project2 = new Project();
		Project project3 = new Project();

		project1.setProjectID(1485);
		project1.setProjectName("Wind Turbine Software");

		project2.setProjectID(1459);
		project2.setProjectName("Facebook Application");

		project3.setProjectID(1478);
		project3.setProjectName("GE Web Applivatin");

		List<Employee> list1 = new ArrayList<Employee>();
		List<Project> list2 = new ArrayList<Project>();

		list1.add(employee1);
		list1.add(employee2);
		list1.add(employee3);

		list2.add(project1);
		list2.add(project2);
		list2.add(project3);

		employee1.setProjects(list2);
		project1.setEmployees(list1);

		employee2.setProjects(list2);

		project3.setEmployees(list1);

		employee3.setProjects(list2);

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		session.persist(employee1);
		session.persist(employee2);
		session.persist(employee3);

		session.persist(project1);
		session.persist(project2);
		session.persist(project3);

		transaction.commit();

		sessionFactory.close();

	}

}
