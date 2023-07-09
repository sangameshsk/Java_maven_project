package com.map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo {

	public static void main(String[] args) {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		// Creating questions

//		Question question = new Question();
//		question.setQuestionId(121);
//		question.setQuestion("What is Java");
//
//		// Creating answer object
//
//		List<Answer> list = new ArrayList<Answer>();
//
//		Answer answer = new Answer();
//		answer.setAnswerId(225);
//		answer.setAnswer("Java is high level Programming language");
//		answer.setQuestion(question);
//		list.add(answer);
//
//		Answer answer1 = new Answer();
//		answer1.setAnswerId(25);
//		answer1.setAnswer("Java can help to build softwares");
//		answer1.setQuestion(question);
//		list.add(answer1);
//
//		Answer answer2 = new Answer();
//		answer2.setAnswerId(21);
//		answer2.setAnswer("Java was released at 1995");
//		answer2.setQuestion(question);
//		list.add(answer2);
//
//		question.setAnswers(list);

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

//		session.persist(question);
//		session.persist(answer);
//		session.persist(answer1);
//		session.persist(answer2);

		Question question = session.get(Question.class, 121);
		System.out.println(question.getQuestionId());
		System.out.println(question.getQuestion());
		System.out.println(question.getAnswers().size());

//		for (Answer answer : question.getAnswers()) {
//			System.out.println(answer.getAnswer());
//		}

		transaction.commit();

		// fetching....

		/*
		 * Question newQuestion = session.get(Question.class, 121);
		 * System.out.println(newQuestion.getQuestion());
		 * System.out.println(newQuestion.getAnswer().getAnswer());
		 */

		/*
		 * List<Question> questions = session.createQuery("FROM Question",
		 * Question.class).list();
		 *
		 * // Iterate through the questions for (Question question11 : questions) {
		 * System.out.println("Question: " + question11.getQuestion());
		 * System.out.println("Answer: " + question11.getAnswer().getAnswer());
		 * System.out.println(); }
		 */

		session.close();

		sessionFactory.close();
	}

}
