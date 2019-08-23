package com.greatdigitallab.hibernate.main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.greatdigitallab.hibernate.entity.Course;
import com.greatdigitallab.hibernate.entity.Trainer;
import com.greatdigitallab.hibernate.entity.TrainerDetail;

public class ReadTrainerCourseLAZYSeparateDemo {

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
			System.out.println("Retrieved Trainer : " + trainer + "\n");

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("\nClosing the session...");

			// Close the session
			session.close();

			System.out.println("Session closed..!!\n");

			System.out.println("Creating New Session..!!\n");
			// Get the current session
			session = sessionFactory.getCurrentSession();
			
			System.out.println("Created New Session..!!\n");
			// Start the transaction
			session.beginTransaction();

			// Get courses for a given instructor
			Query<Course> fetchQuery = session.createQuery("SELECT c FROM Course c WHERE c.trainer.id=:trainerId", Course.class);

			// Set parameter on query
			fetchQuery.setParameter("trainerId", id);

			// Execute query and get Trainer object
			List<Course> courses = fetchQuery.getResultList();

			// Display the Trainer object
			System.out.println("Retrieved Courses : " + courses + "\n");

			// Assign the courses to trainer object in memory
			trainer.setCourses(courses);
			
			System.out.println("Going to print Courses...\n");

			// Display the associated Courses object
			System.out.println("Associated Courses : " + trainer.getCourses());

			System.out.println("\nLAZY Loading Done with Course Fetch Query..!!");
		}catch (Exception e) {
			e.printStackTrace();		
		}finally {
			// Close the session
			session.close();
			sessionFactory.close();
		}
	}
}
