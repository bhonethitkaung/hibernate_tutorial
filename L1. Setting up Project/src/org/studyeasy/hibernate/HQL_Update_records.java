package org.studyeasy.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.hibernate.entity.Users;

public class HQL_Update_records {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Users.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			
			session.createQuery("update users set password = 'bhonepann123456' where first_name = 'bhone' AND last_name = 'pann'").executeUpdate();
			
			session.getTransaction().commit();
			
		} finally {
			session.close();
			factory.close();
		}
	}
}
