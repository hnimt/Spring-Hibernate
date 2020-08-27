package com.Minh.hibernate.demo.start;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Minh.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
//		create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
				
//		create session
		Session session = factory.getCurrentSession();
		
		try {		
//			start a transaction
			session.beginTransaction();
			
//			Create studentId for check object:
			int studentId = 1;
			
//			set object with data in database:
			Student theStudent = session.get(Student.class, studentId);
			
//			update object:
			theStudent.setFirstName("Luffy");
			
//			commit transaction
			session.getTransaction().commit();
			
//			NEWCODE: update all
//			Create session:
			session = factory.getCurrentSession();
			session.beginTransaction();
			
//			execute update:
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
//			Commit transaction:
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
		
		
		
		
	}

}
