package com.intimetec.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateSessionFactory {
	static boolean flag = false;

	static SessionFactory sessionFactory;

	private static boolean isSessionFactoryCreated() {
		return flag;
	}

	Session getSession() {
		if (!isSessionFactoryCreated()) {
			sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
			flag = true;
		}
		return sessionFactory.openSession();
	}

	public static void closeSessionFactory() {
		sessionFactory.close();
	}
}
