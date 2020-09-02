package com.Minh.hibernate.demo.start;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Minh.hibernate.demo.entity.Course;
import com.Minh.hibernate.demo.entity.Instructor;
import com.Minh.hibernate.demo.entity.InstructorDetail;
import com.Minh.hibernate.demo.entity.Review;
import com.Minh.hibernate.demo.entity.Student;

public class CreateCourseAndReviewDemo {

	public static void main(String[] args) {
		
//		create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory();
				
//		create session
		Session session = factory.getCurrentSession();
		
		try {		
//			Start transaction
			session.beginTransaction();
			
//			create course
			Course tempCourse = new Course("Data Science");
			
//			Create reviews
			tempCourse.addReview(new Review("I love it so much"));
			tempCourse.addReview(new Review("I hate it a little bit"));
			tempCourse.addReview(new Review("It's quite good course"));
			
//			Save course
			session.save(tempCourse);
			
//			commit trasaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
//			commit trasaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}
		
		
		
		
	}

}
