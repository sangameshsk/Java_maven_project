package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		System.out.println("Project started...!");

		Scanner scanner = new Scanner(System.in);

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Student s = new Student();
		// System.out.print("Enter student ID: ");

		// s.setId(scanner.nextInt());
		s.setId(2);
		// scanner.nextLine();
		// System.out.print("Enter student Name: ");

		// s.setNameString(scanner.nextLine());
		s.setName("Sangamesh");
		// scanner.nextLine();
		// System.out.print("Enter student city: ");
		// scanner.nextLine();
		// s.setCity(scanner.nextLine());
		s.setCity("Almatti");

		System.out.println(s);

		Address address = new Address();
		address.setStreet("street5");
		address.setCity("Bengaluru");
		address.setOpen(true);
		address.setAddeDate(new Date());
		address.setX(1234.234);

		// reading image

		FileInputStream fileInputStream = new FileInputStream("src/main/java/Thumb.jpeg");
		int[] data = new int[fileInputStream.available()];
		address.setImage(data);

		Session session = factory.openSession();

		session.beginTransaction();

		session.persist(s);
		session.persist(address);

		session.getTransaction().commit();

		session.close();
		System.out.println("Done");

		scanner.close();

	}
}
