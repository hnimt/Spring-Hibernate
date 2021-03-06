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
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				
//		create session
		Session session = factory.getCurrentSession();
		
		try {		
//			Start transaction
			session.beginTransaction();
			
//			create course
			Course tempCourse = new Course("Data Science");
			
//			Create student
			Student tempStudent1 = new Student("Tong", "Minh", "tongminh23996@gmail.com");
			Student tempStudent2 = new Student("Cong", "Minh", "congminh23996@gmail.com");
			Student tempStudent3 = new Student("Minh", "Minh", "minhminh23996@gmail.com");
			
//			Add student
			tempCourse.addStudent(tempStudent1);
			tempCourse.addStudent(tempStudent2);
			tempCourse.addStudent(tempStudent3);
			
//			Save course
			session.save(tempCourse);
			
//			Save student
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			System.out.println("My course is: " + tempCourse);
			
//			commit trasaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		}
		
		
		
		
	}

}
