package com.Minh.hibernate.demo.start;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.Minh.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
			
//			Query list student:
			List<Student> theStudentsList = session.createQuery("from Student").getResultList();
			
//			DisplayStudent:
			displayStudents(theStudentsList);
			
//			Query Student with Condition:
			theStudentsList = 
					session.createQuery("from Student s where s.lastName = 'Minh3'").getResultList();
			
//			Display new query:
			displayStudents(theStudentsList);
				
//			commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
		
		
		
		
	}

	private static void displayStudents(List<Student> theStudentsList) {
		for (Student tempStudent : theStudentsList) {
			System.out.println(tempStudent);
		}
	}

}
