package org.studyeasy.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.studyeasy.hibernate.entity.Users;

public class HQL_Listing_records {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Users.class)
				.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			session.beginTransaction();
			List<Users> users = session.createQuery("from users where first_name = 'bhone'"
					+ "OR last_name like '%hi%'").getResultList();
			
			for (Users temp : users) {
				System.out.println(temp);
			}
			
			//session.getTransaction().commit();
			
			
		} finally {
			session.close();
			factory.close();
		}
	}
}
