package com.hcl.DemoHibernate;

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

		EmployeeHibernate employee = new EmployeeHibernate();
		
		Name obj = new Name();
		obj.setFirstName("kothapalli");
		obj.setLastName("vanisree");
		
		employee.setId(3);
		employee.setName(obj);

		Configuration cfg = new Configuration().configure().addAnnotatedClass(EmployeeHibernate.class);

		// buildSessionFactory is depricated so we use service registry for this
		ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(cfg.getProperties()).buildServiceRegistry();
		SessionFactory sf = cfg.buildSessionFactory(reg);
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		session.save(employee);
		// employee = (EmployeeHibernate)session.get(EmployeeHibernate.class,
		// 1);
		tx.commit();
		// System.out.println(employee);
	}
}
