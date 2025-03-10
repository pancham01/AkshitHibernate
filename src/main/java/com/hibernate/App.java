package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.config.HibernateConfiguration;
import com.hibernate.entity.Address;
import com.hibernate.entity.Employee;

public class App {

	private static void save(Session session) {
		Address ad1 = new Address("Mumbai", "MAHA");

//		Employee e = new Employee("Utkarsh", "male", 94944, ad1);
		Employee e = new Employee();
		e.setName("Mukul");
		e.setGender("male");
		e.setSalary(98754);
		e.setAddress(ad1);
		
//		injecting employee to the address
		ad1.setEmployee(e);
		
		session.persist(ad1);
		session.persist(e);
		session.beginTransaction().commit();

	}

	private static void fetchEmployee(Session session) {
		Employee employee = session.get(Employee.class, 2);

		System.out.println(employee);
		System.out.println(employee.getAddress());
	}
	
	
	
	private static void fetchAddress(Session session) {
		Address address = session.get(Address.class, 1);

		System.out.println(address);
		System.out.println(address.getEmployee());
	}

	public static void main(String[] args) {


		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();

//		save(session);
		
		fetchEmployee(session);
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>");
		
		fetchAddress(session);
		
		sessionFactory.close();

	}

}
