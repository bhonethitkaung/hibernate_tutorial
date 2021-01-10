package org.studyeasy.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.hibernate.entity.Users;

public class Update_record {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Users.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			// Create object of entity class type
			Users user = new Users();
			
			// Start transaction
			session.beginTransaction();
			
			// Perform operation
			user = session.get(Users.class, 3);
			
			// Updating object
			user.setUsername("pann");
			
			// Commit the transaction
			session.getTransaction().commit();
			
			System.out.println(user);
			
			
		} finally {
			session.close();
			factory.close();
		}
	}
}
