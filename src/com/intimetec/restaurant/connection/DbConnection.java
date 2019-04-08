package com.intimetec.restaurant.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DbConnection {
	private static SessionFactory sessionFactory = null;

	private DbConnection() {

	}

	public static Session getSession() {
		if (sessionFactory == null) {
			try {
				sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();

			} catch (Exception e) {
				System.err.println(e.getMessage());
				e.printStackTrace();
				return null;
			}
		}

		try {
			return sessionFactory.openSession();
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return null;
		}
	}
}
