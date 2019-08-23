package com.greatdigitallab.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatdigitallab.hibernate.entity.Course;
import com.greatdigitallab.hibernate.entity.Trainer;
import com.greatdigitallab.hibernate.entity.TrainerDetail;

public class ReadTrainerCourseLAZYExceptionDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Trainer.class)
				.addAnnotatedClass(TrainerDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();

		// Create session
		Session session = sessionFactory.getCurrentSession();

		try {

			// Start the transaction
			session.beginTransaction();

			// Get the TrainerDetail by primary key - id
			System.out.println("Reading Trainer from database...");
			int id = 4;
			Trainer trainer = session.get(Trainer.class, id);

			// Display the Trainer object
			System.out.println("Retrieved Trainer : " + trainer);

			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("\nClosing the session...");
			
			// Close the session
			session.close();
			
			System.out.println("Session closed..!!\n");

			System.out.println("Going to print Courses...\n");

			// Display the associated Courses object
			System.out.println("Associated Courses : " + trainer.getCourses());

			System.out.println("LAZY Loading Done..!!");
		}catch (Exception e) {
			e.printStackTrace();		
		}finally {
			// Close the session
			session.close();
			sessionFactory.close();
		}
	}
}
