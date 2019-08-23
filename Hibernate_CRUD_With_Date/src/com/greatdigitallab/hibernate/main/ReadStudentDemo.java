package com.greatdigitallab.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatdigitallab.hibernate.entity.Student;

public class ReadStudentDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		// Create Session Object
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// Create Student Object
			System.out.println("Creating the student object..");
			Student student = new Student("Mangesh", "Gayakwad", "mangeshg@gmail.com");
			
			// Start transaction
			System.out.println("Starting the transaction..");
			session.beginTransaction();
			
			// Save the Student Object
			System.out.println("Saving the student object.. " + student);
			session.save(student);
			
			// Commit the transaction
			System.out.println("Commit transaction..");
			session.getTransaction().commit();
			
			/*
			 * Below code is to read/ retrieve the student from database using id (primary key)
			 */
			
			// Now get a new session and start transaction
			session = sessionFactory.getCurrentSession();
			
			// start the transaction
			session.beginTransaction();
			
			// Retrieve student based on primary key : id
			System.out.println("\nReading Student with id : " + student.getId());
			
			Student myStudent = session.get(Student.class, student.getId());
			
			System.out.println("Student Read : " + myStudent);
			
			// Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Reading Done..!!");
		}finally{
			// Close the Session Factory
			sessionFactory.close();
		}
	}

}
