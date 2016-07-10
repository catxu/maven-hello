package com.catxu.user.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtil {
	private final static SessionFactory FACTORY = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		Configuration conf = new Configuration().configure();
		ServiceRegistry serviceRegistery = (ServiceRegistry) new ServiceRegistryBuilder().applySettings(conf.getProperties());
		SessionFactory sf = conf.buildSessionFactory(serviceRegistery);
		return sf;
	}

	public static SessionFactory getFactory() {
		return FACTORY;
	}

	public static Session openSession() {
		return FACTORY.openSession();
	}

	public static void close(Session session) {
		if(session != null)
				session.close();
	}
}
