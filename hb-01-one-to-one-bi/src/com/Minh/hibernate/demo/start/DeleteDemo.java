package com.Minh.hibernate.demo.start;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Minh.hibernate.demo.entity.Instructor;
import com.Minh.hibernate.demo.entity.InstructorDetail;
import com.Minh.hibernate.demo.entity.Student;

public class DeleteDemo {

	public static void main(String[] args) {
		
//		create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.buildSessionFactory();
				
//		create session
		Session session = factory.getCurrentSession();
		
		try {					
//			1. start a transaction
//			2. Get instructor by key
//			3. Delete instructor
			session.beginTransaction();
			
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Found instructor" + tempInstructor);
			
			if(tempInstructor != null) {
				System.out.println("Delete instructor: " + tempInstructor);	
				session.delete(tempInstructor);
			}
			
//			commit trasaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			session.close();
			factory.close();
		}
		
	}

}
