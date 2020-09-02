package com.Minh.hibernate.demo.start;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Minh.hibernate.demo.entity.Course;
import com.Minh.hibernate.demo.entity.Instructor;
import com.Minh.hibernate.demo.entity.InstructorDetail;
import com.Minh.hibernate.demo.entity.Review;
import com.Minh.hibernate.demo.entity.Student;

public class CreateCourseToTongDemo {

	public static void main(String[] args) {
		
//		create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				
//		create session
		Session session = factory.getCurrentSession();
		
		try {		
//			Start transaction
			session.beginTransaction();
			
//			Get student
			int theId = 1;
			Student tempStudent = session.get(Student.class, theId);
			
//			Create course
			Course tempCourse1 = new Course("Spring hibernate");
			Course tempCourse2 = new Course("Asp.net mvc core");
				
//			Add student into new course
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
//			Save course
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
