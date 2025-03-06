package com.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.hibernate.config.HibernateConfiguration;
import com.hibernate.entity.Employee;

public class App {

	public static void main(String[] args) {
		Employee e1 = new Employee("Ansh", "male", 94944);
		Employee e2 = new Employee("John", "male", 94944);
		Employee e3 = new Employee("Vikas", "male", 94944);
		Employee e4 = new Employee("Ashish", "male", 194944);
		Employee e5 = new Employee("Aditi", "female", 94944);
		Employee e6 = new Employee("Sameer", "female", 94944);
		SessionFactory sessionFactory = HibernateConfiguration.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
//		session.persist(e1);
//		session.persist(e2);
//		session.persist(e3);
//		session.persist(e4);
//		session.persist(e5);
//		session.persist(e6);
//		tx.commit();

//		Query query = session.createQuery("from Employee",Employee.class);
//		List list = query.list();
//		System.out.println(list);

//		Query query = session.createQuery("from Employee");
//		query.setFirstResult(3);
//		query.setMaxResults(5);
//		List list = query.list();
//		System.out.println(list);

//		Query query = session.createQuery("update Employee set name =:n where id =:i");
//		query.setParameter("n", "Shiv");
//		query.setParameter("i", 3);
//		
//		query.executeUpdate();

//		Query query = session.createQuery("delete from Employee  where id =3");
//		query.executeUpdate();
//		tx.commit();
		Query query1 = session.createQuery("select max(salary) from Employee");

		System.out.println(query1.list());

		sessionFactory.close();
	}

}
