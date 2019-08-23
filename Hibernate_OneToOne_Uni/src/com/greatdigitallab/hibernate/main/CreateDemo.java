package com.greatdigitallab.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatdigitallab.hibernate.entity.Trainer;
import com.greatdigitallab.hibernate.entity.TrainerDetail;

public class CreateDemo {

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
			// create the objects for Trainer and TrainerDetail
			Trainer trainer = new Trainer("Ananad", "Polas", "anandp@gmail.com");
			
			TrainerDetail trainerDetail = new TrainerDetail("Yoga", "Certified Trainer");
			
			// Associate the Objects
			trainer.setTrainerDetail(trainerDetail);
			
			// Start the transaction
			session.beginTransaction();
			
			// Save the Trainer object in database
			// It also saves the TrainerDetail object in database because of cascade all
			System.out.println("Saving Trainer : " + trainer);
			session.save(trainer);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Saving Done..!!");
		}finally {
			// Close the session
			session.close();
		}
	}
}
