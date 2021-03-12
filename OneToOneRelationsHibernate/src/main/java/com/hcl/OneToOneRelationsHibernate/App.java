package com.hcl.OneToOneRelationsHibernate;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class App {
	public static void main(String[] args)

	{

		
		Laptop laptop = new Laptop(101, "dell");
		
	
		Student student = new Student();
		student.setStudentId(1);
		student.setStudentName("vani");
		student.setCity("Bangalore");
		student.setLaptop(laptop);
		
		laptop.setStudent(student);

		Configuration cfg = new Configuration().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class)
				.configure();

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(student);
		session.save(laptop);
		

		tx.commit();

		session.close(); // close the session
		sf.close();

	}
}
