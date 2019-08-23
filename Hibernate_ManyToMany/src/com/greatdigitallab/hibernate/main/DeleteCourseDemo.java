package com.greatdigitallab.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatdigitallab.hibernate.entity.Course;
import com.greatdigitallab.hibernate.entity.Trainer;
import com.greatdigitallab.hibernate.entity.TrainerDetail;

public class DeleteCourseDemo {

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
			int id = 1;
			Course course = session.get(Course.class, id);

			// Display the Course object
			System.out.println("Retrieved Course : " + course);

			// Delete the Course
			System.out.println("Deleting Course : " + course);
			
			session.delete(course);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Deletion Done..!!");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// Close the session
			session.close();
			sessionFactory.close();
		}
	}
}
