package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Employee;

public class App {

	public static void main(String[] args) {
		Employee e = new Employee("Nakul", "male", 94944);
		SessionFactory sessionFactory = new MetadataSources(
				new StandardServiceRegistryBuilder().configure("hibernate.cfg1.xml").build()).getMetadataBuilder()
				.build().buildSessionFactory();

		Session session = sessionFactory.openSession();

		session.persist(e);
		session.beginTransaction().commit();
		sessionFactory.close();
	}

}
