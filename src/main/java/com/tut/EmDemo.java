package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Student student1 = new Student();
		student1.setId(101);
		student1.setName("Manju");
		student1.setCity("Bijapur");

		Certificate certificate = new Certificate();

		certificate.setCourse("Android");
		certificate.setDuration("2 Months");

		student1.setCertificate(certificate);

		Student student2 = new Student();
		student2.setId(102);
		student2.setName("Shiva");
		student2.setCity("Bagalkot");

		Certificate certificate1 = new Certificate();

		certificate1.setCourse("Java Full Stack");
		certificate1.setDuration("6 Months");

		student2.setCertificate(certificate1);

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		// objects save

		session.persist(student1);
		session.persist(student2);

		transaction.commit();
		session.close();
		sessionFactory.close();

	}

}
