package com.greatdigitallab.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatdigitallab.hibernate.entity.Student;

public class DeleteStudentDemo {

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

			//Delete the Student Object who has id 1
			System.out.println("Deleting the Student Object who has id 1");

			session.delete(myStudent);
			
			// Commit the transaction
			session.getTransaction().commit();

			System.out.println("Deleted Student for id 1..!!");


			// Delete Student who has id 3 using HQL

			// Now get a new session and start transaction
			session = sessionFactory.getCurrentSession();

			// start the transaction
			session.beginTransaction();

			// Update all emailid's
			System.out.println("\n\nDeleting Student who has id 3 using HQL");
			
			session.createQuery("delete from Student where id = 2").executeUpdate();

			// Commit the transaction
			session.getTransaction().commit();

			System.out.println("Deleted Student for id 3 using HQL..!!");

		}finally{
			// Close the Session Factory
			sessionFactory.close();
		}
	}

}