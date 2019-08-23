package com.greatdigitallab.hibernate.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatdigitallab.hibernate.entity.Student;

public class PrimaryKeyDemo {

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
					System.out.println("Creating 3 student objects..");
					Student student1 = new Student("Anand", "Polas", "anand@gmail.com");
					Student student2 = new Student("John", "Thomas", "john@gmail.com");
					Student student3 = new Student("MahindraSingh", "Dhoni", "msdhoni@gmail.com");
					
					// Start transaction
					System.out.println("Starting the transaction..");
					session.beginTransaction();
					
					// Save the Student Object
					System.out.println("Saving 3 student objects..");
					session.save(student1);
					session.save(student2);
					session.save(student3);
					
					// Commit the transaction
					System.out.println("Commit transaction..");
					session.getTransaction().commit();
					
				}finally{
					// Close the Session Factory
					sessionFactory.close();
				}
	}

}
