package com.Minh.hibernate.demo.start;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Minh.hibernate.demo.entity.Course;
import com.Minh.hibernate.demo.entity.Instructor;
import com.Minh.hibernate.demo.entity.InstructorDetail;

public class EagerLazyDemo {

	public static void main(String[] args) {
		
//		create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
				
//		create session
		Session session = factory.getCurrentSession();
		
		try {					
			session.beginTransaction();
			
//			Get instructor detail object
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
//			Print instructor detail
			System.out.println("My instructor detail: " + tempInstructor);
			
//			Print associated
			System.out.println("Instructor in my instructor detail: " + tempInstructor.getInstructorDetail());
			
//			Get courses from instructor:
			System.out.println("luv2code: Courses: " + tempInstructor.getCourses());
			
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
