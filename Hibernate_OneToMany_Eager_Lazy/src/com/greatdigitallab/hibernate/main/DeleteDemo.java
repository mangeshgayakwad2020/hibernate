package com.greatdigitallab.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatdigitallab.hibernate.entity.Trainer;
import com.greatdigitallab.hibernate.entity.TrainerDetail;

public class DeleteDemo {

	public static void main(String[] args) {

		// Create session factory
		SessionFactory sessionFactory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Trainer.class)
				.addAnnotatedClass(TrainerDetail.class)
				.buildSessionFactory();

		// Create session
		Session session = sessionFactory.getCurrentSession();

		try {

			// Start the transaction
			session.beginTransaction();

			// Get the TrainerDetail by primary key - id
			int id = 2;
			TrainerDetail trainerDetail = session.get(TrainerDetail.class, id);

			// Display the TrainerDetail object
			System.out.println("Retrieved TrainerDetail : " + trainerDetail);

			// Display the associated Trainer object
			System.out.println("Retrieved Associated Trainer : " + trainerDetail.getTrainer());

			// Delete the TrainerDetail
			session.delete(trainerDetail);

			// commit the transaction
			session.getTransaction().commit();

			System.out.println("Bi-Directional Mapping Deletion Done..!!");
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			// Close the session
			session.close();
			sessionFactory.close();
		}
	}
}
