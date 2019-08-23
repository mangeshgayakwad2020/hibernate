package com.greatdigitallab.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatdigitallab.hibernate.entity.Course;
import com.greatdigitallab.hibernate.entity.Review;
import com.greatdigitallab.hibernate.entity.Student;
import com.greatdigitallab.hibernate.entity.Trainer;
import com.greatdigitallab.hibernate.entity.TrainerDetail;

public class DeleteManyToManyDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Trainer.class)
				.addAnnotatedClass(TrainerDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// Create session
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// Start the transaction
			session.beginTransaction();
			
			// Get the Course
			int id = 5;
			Course course = session.get(Course.class, id);
			
			// Display the Course
			System.out.println("Deleting Course : " + course);
			
			// Delete the Course
			session.delete(course);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Deletion Done..!!");
		}finally {
			// Close the session
			session.close();
		}
	}
}