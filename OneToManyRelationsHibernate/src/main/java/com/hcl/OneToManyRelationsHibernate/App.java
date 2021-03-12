package com.hcl.OneToManyRelationsHibernate;

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

		Student student = new Student();
		student.setStudentId(1);
		student.setStudentName("vani");
		student.setCity("Bangalore");
		student.getLaptops().add(laptop1);
		student.getLaptops().add(laptop2);

		laptop1.setStudent(student);
		laptop2.setStudent(student);

		Configuration cfg = new Configuration().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class)
				.configure();

		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();

		SessionFactory sf = cfg.buildSessionFactory();

		Session session = sf.openSession();

		Transaction tx = session.beginTransaction();

		session.save(student);
		session.save(laptop1);
		session.save(laptop2);

		tx.commit();

		session.close(); // close the session
		sf.close();
	}
}
