package com.states;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tut.Certificate;
import com.tut.Student;

public class StateDemo {
	public static void main(String[] args) {
		// Practical of hibernate Object States:
		// Transient
		// Persistent
		// Detached
		// Removed
		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		// Creating student object

		Student student = new Student();

		student.setId(12154);
		student.setName("Sangamesh");
		student.setCity("Mysore");
		student.setCertificate(new Certificate("Java Hibernate course", "2 month"));
		// Student : Trnasient

		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		// student : Persistante availabe at both session and databse
		// session.persist(student);
		// student.setName("Prateik");

		// Fetching the student with ID 12154
		Student student1 = session.find(Student.class, 12154);

		System.out.println(student1);
		// Deleting the student
		session.remove(student1);

		transaction.commit();

		session.close();
		// student : Detached
//		student.setName("Sachin");
//		System.out.println(student);

		factory.close();

	}
}
