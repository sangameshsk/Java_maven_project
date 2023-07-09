package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.tut.Student;

public class FirstDemo {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		Student student = session.get(Student.class, 101);
		System.out.println(student);

		System.out.println("Doing some updation work");

		Student student2 = session.get(Student.class, 101);
		System.out.println(student2);

		session.close();

	}

}
