package com.greatdigitallab.hibernate.main;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.greatdigitallab.hibernate.entity.Student;
import com.greatdigitallab.hibernate.main.util.DateUtils;

public class CreateStudentDOBDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory sessionFactory = new Configuration()
										.configure("hibernate.cfg.xml")
										.addAnnotatedClass(Student.class)
										.buildSessionFactory();
		
		// Create Session Object
		Session session = sessionFactory.getCurrentSession();
		
		try {
			
			// Getting a date in String format and converting it into Date format
			String dateOfBirth = "02/04/1995";
			
			Date myDateOfBirth = DateUtils.parseDate(dateOfBirth);
			
			// Create Student Object
			System.out.println("Creating the student object..");
			Student student = new Student("Mangesh", "Gayakwad", "mangeshg@gmail.com", myDateOfBirth);
			
			// Start transaction
			System.out.println("Starting the transaction..");
			session.beginTransaction();
			
			// Save the Student Object
			System.out.println("Saving the student object..");
			session.save(student);
			
			// Commit the transaction
			System.out.println("Commit transaction..");
			session.getTransaction().commit();
			
		}catch (Exception e) {
			// Print the exception
			e.printStackTrace();
		}
		finally{
			// Close the Session Factory
			sessionFactory.close();
		}
	}

}
