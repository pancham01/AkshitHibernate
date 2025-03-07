package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.config.HibernateConfiguration;
import com.hibernate.entity.Employee;

public class App {

	public static void main(String[] args) {
		Employee e = new Employee("Utkarsh", "male", 94944,"UP");
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.persist(e);
		session.beginTransaction().commit();
		sessionFactory.close();
	}

}
