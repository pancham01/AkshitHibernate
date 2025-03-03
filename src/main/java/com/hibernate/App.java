package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Employee;

public class App {

	public static void main(String[] args) {
		Employee e = new Employee( "Nakul", "male", 94944);
		
		Configuration cfg = new Configuration().configure("hibernate.cfg1.xml");
		SessionFactory sessionFactory = cfg.buildSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(e);
		tx.commit();
		
	}

}


