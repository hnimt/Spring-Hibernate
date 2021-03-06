package com.Minh.hibernate.demo.start;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Minh.hibernate.demo.entity.Instructor;
import com.Minh.hibernate.demo.entity.InstructorDetail;
import com.Minh.hibernate.demo.entity.Student;

public class CreateDemo {

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
//			create a student object
			Instructor tempInstructor = new Instructor("Cong", "Minh", "minhcong@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("congminh.youtube.com", "programming");
	
//			assosiate object
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			
//			start a transaction
			session.beginTransaction();
			
//			Save transaction
			System.out.println("Saving:... " + tempInstructor);
			session.save(tempInstructor);
			
//			commit trasaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
		
		
		
		
	}

}
