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
//		1st 
//		Configuration cfg = new Configuration().configure("hibernate.cfg1.xml");
//		SessionFactory sessionFactory = cfg.buildSessionFactory();

//		2nd
//		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg1.xml").buildSessionFactory();
		
//		3rd
//		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg1.xml").build();
//		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
//		SessionFactory sessionFactory = meta.buildSessionFactory();
		
//		4th
		SessionFactory sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure("hibernate.cfg1.xml").build()).getMetadataBuilder().build().buildSessionFactory();
	
		Session session = sessionFactory.openSession();
		session.save(e);
		session.beginTransaction().commit();

	}

}
