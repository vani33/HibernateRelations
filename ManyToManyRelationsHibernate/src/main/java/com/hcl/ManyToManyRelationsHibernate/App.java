package com.hcl.ManyToManyRelationsHibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		Laptop laptop1 = new Laptop(101, "dell");
		Laptop laptop2 = new Laptop(102, "hp");

		Student student1 = new Student(1, "vani", "bangalore");
		student1.getLaptops().add(laptop1);
		student1.getLaptops().add(laptop2);
		Student student2 = new Student(2, "kavya", "chennai");
		student2.getLaptops().add(laptop1);
		student2.getLaptops().add(laptop2);

		laptop1.getStudent().add(student1);
		laptop1.getStudent().add(student2);
		laptop2.getStudent().add(student1);
		laptop2.getStudent().add(student2);

		Configuration cfg = new Configuration().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class)
				.configure();

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(student1);
		session.save(student2);
		session.save(laptop1);
		session.save(laptop2);

		tx.commit();

		session.close(); // close the session
		sf.close();
	}
}
