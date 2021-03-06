package com.Minh.hibernate.demo.start;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Minh.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
//			delete object:
			session.delete(theStudent);
		
//			Way 2: Use query
			
//			execute update:
			session.createQuery("delete from Student where id=2").executeUpdate();
			
//			commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
		
		
		
		
	}

}
