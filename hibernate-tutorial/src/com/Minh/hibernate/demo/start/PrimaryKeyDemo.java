package com.Minh.hibernate.demo.start;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Minh.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

public static void main(String[] args) {
		
//		create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				
//		create session
		Session session = factory.getCurrentSession();
		
		try {		
//			create a student object
			System.out.println("Creating new student object...");
			Student tempStudent1 = new Student("Tong", "Minh", "minh@gmail.com");
			Student tempStudent2 = new Student("Tong", "Minh2", "minh2@gmail.com");
			Student tempStudent3 = new Student("Tong", "Minh3", "minh3@gmail.com");
			
//			start a transaction
			session.beginTransaction();
			
//			save the student object
			System.out.println("Saving the student ...");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
//			commit trasaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
		
		
		
		
	}
}
