package com.Minh.hibernate.demo.start;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.Minh.hibernate.demo.entity.Course;
import com.Minh.hibernate.demo.entity.Instructor;
import com.Minh.hibernate.demo.entity.InstructorDetail;

public class FetchJoinDemo {

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
			
//			Set instructor id:
			int theId = 1;
			
//			Set up query by HQL:
			Query<Instructor> query = session.createQuery("select i from Instructor i " + 
									"join fetch i.courses " + 
									"where i.id=:theInstructorId", Instructor.class);
			
//			set parameter for query:
			query.setParameter("theInstructorId", theId);
			
//			get result from query
			Instructor tempInstructor = query.getSingleResult();
			System.out.println("Instructor" + tempInstructor);
		
//			commit trasaction
			session.getTransaction().commit();
			session.close();
			
			System.err.println("Courses" + tempInstructor.getCourses());
			
			System.out.println("Done!");
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			
			factory.close();
		}
		
	}

}
