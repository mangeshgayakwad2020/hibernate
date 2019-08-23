package com.greatdigitallab.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatdigitallab.hibernate.entity.Student;

public class CreateStudentDemo {

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
			System.out.println("Saving the student object..");
			session.save(student);
			
			// Commit the transaction
			System.out.println("Commit transaction..");
			session.getTransaction().commit();
			
		}finally{
			// Close the Session Factory
			sessionFactory.close();
		}
	}

}
