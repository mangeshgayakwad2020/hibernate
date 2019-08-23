package com.greatdigitallab.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatdigitallab.hibernate.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		// Create Session Factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create Session Object
		Session session = sessionFactory.getCurrentSession();

		try {

			int studentId = 1;

			// Now get a new session and start transaction
			session = sessionFactory.getCurrentSession();

			// start the transaction
			session.beginTransaction();

			// Retrieve student based on primary key : id
			System.out.println("\nReading Student with id : " + studentId);

			Student myStudent = session.get(Student.class, studentId);

			// Updating student name to "Mass" who has student id 1
			myStudent.setFirstName("Mass");

			// Commit the transaction
			session.getTransaction().commit();

			System.out.println("Update Done for Name..!!");


			// Update all the emailid's to the "athlete@gmail.com"

			// Now get a new session and start transaction
			session = sessionFactory.getCurrentSession();

			// start the transaction
			session.beginTransaction();

			// Update all emailid's
			System.out.println("\n\nUpdating all the emailid's to the 'athlete@gmail.com'");
			
			session.createQuery("update Student set email = 'athlete@gmail.com'").executeUpdate();

			// Commit the transaction
			session.getTransaction().commit();

			System.out.println("Update Done for all Email id's..!!");

		}finally{
			// Close the Session Factory
			sessionFactory.close();
		}
	}

}