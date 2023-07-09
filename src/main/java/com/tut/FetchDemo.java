package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {
	public static void main(String[] args) {
		// get , load

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session session = sessionFactory.openSession();
		// get- student id=1
		Student student = session.get(Student.class, 2);
		System.out.println(student);

		Address address = session.get(Address.class, 1);
		System.out.println(address.getStreet());
		session.close();
		sessionFactory.close();
	}
}
