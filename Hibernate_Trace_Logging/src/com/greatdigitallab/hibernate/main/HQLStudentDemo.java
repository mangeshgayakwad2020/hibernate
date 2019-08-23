package com.greatdigitallab.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatdigitallab.hibernate.entity.Student;

public class HQLStudentDemo {

	public static void main(String[] args) {

		// Create Session Factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create Session Object
		Session session = sessionFactory.getCurrentSession();

		try {

			// Start transaction
			System.out.println("Starting the transaction..");
			session.beginTransaction();

			
			// Read all the Students
			System.out.println("\n\nReading all the Students..\n");
			List<Student> allStudents = session.createQuery("from Student").getResultList();

			// Display all the Students
			displayStudents(allStudents);
			
			// Read all the Students
			System.out.println("\n\nReading all the Students whoes last name is 'Gayakwad'..\n");
			allStudents = session.createQuery("from Student s where s.lastName='Gayakwad'").getResultList();		
			
			// Display all the Students
			displayStudents(allStudents);
			
			// Read all the Students
			System.out.println("\n\nReading Students using OR predicate..\n");
			allStudents = session.createQuery("from Student s where s.lastName='Gayakwad' OR s.firstName='Anand'").getResultList();		
			
			// Display all the Students
			displayStudents(allStudents);
			
			// Read all the Students
			System.out.println("\n\nReading Students using LIKE predicate..\n");
			allStudents = session.createQuery("from Student s where s.email LIKE '%gmail.com'").getResultList();		
				
			// Display all the Students
			displayStudents(allStudents);
			
			// Commit the transaction
			System.out.println("\n\nCommit transaction..");
			session.getTransaction().commit();

		}finally{
			// Close the Session Factory
			sessionFactory.close();
		}
	}

	private static void displayStudents(List<Student> allStudents) {

		for(Student student : allStudents) {
			System.out.println(student);
		}
	}

}