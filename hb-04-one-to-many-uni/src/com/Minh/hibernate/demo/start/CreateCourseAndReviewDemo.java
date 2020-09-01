package com.Minh.hibernate.demo.start;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Minh.hibernate.demo.entity.Course;
import com.Minh.hibernate.demo.entity.Instructor;
import com.Minh.hibernate.demo.entity.InstructorDetail;
import com.Minh.hibernate.demo.entity.Student;

public class CreateCourseAndReviewDemo {

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
//			Start transaction
			session.beginTransaction();
	
//			get instructor
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
//			create some courses
			Course tempCourse1 = new Course("Hello World 1");
			Course tempCourse2 = new Course("ABCXYZ");
			
//			add courses into instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
//			save courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			
//			commit trasaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}
		
		
		
		
	}

}
