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
			
			// Get the Trainer by primary key - id
			int id = 1;
			Trainer trainer = session.get(Trainer.class, id);
			System.out.println("Retrieved Trainer : " + trainer);
			
			// Delete the Trainer
			if(trainer != null) {
				System.out.println("Deleting : " + trainer);
				session.delete(trainer);
			}
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Deletion Done..!!");
		}finally {
			// Close the session
			session.close();
		}
	}
}
