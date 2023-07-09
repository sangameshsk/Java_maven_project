package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.tut.Student;

public class HQLExample {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		// HQL quey

		// syntax
		String query = "from Student as session where session.city=:x and session.name=:n";
		Query q = session.createQuery(query);
		q.setParameter("x", "bagalkot");
		q.setParameter("n", "Shiva");

		// single unique
		// multiple list

		List<Student> list = q.list();

		for (Student student : list) {

			System.out.println(student.getName() + ":" + student.getCertificate().getCourse());

		}

		System.out.println("--------------------------");

		Transaction transaction = session.beginTransaction();
//		Query q2 = session.createQuery("delete from Student session where session.city=:c");
//
//		q2.setParameter("c", "almatti");
//
//		int r = q2.executeUpdate();
//		System.out.println("Deleted:");
//		System.out.println(r);

//		Query query2 = session.createQuery("update Student set city=:c where name=:n");
//		query2.setParameter("c", "Almatti");
//		query2.setParameter("n", "shiva");
//		query2.executeUpdate();
//
//		transaction.commit();

		Query q3 = session
				.createQuery("select q.question,q.questionId,a.answer from Question as q INNER JOIN q.answers as a");

		List<Object[]> list3 = q3.getResultList();

		for (Object[] objects : list3) {
			System.out.println(Arrays.toString(objects));
		}

	}

}
