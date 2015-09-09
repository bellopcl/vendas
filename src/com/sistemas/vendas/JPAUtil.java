package com.sistemas.vendas;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class JPAUtil {
	
	private static final SessionFactory session = buildSessionFactory();

	@SuppressWarnings("deprecation")
	private static SessionFactory buildSessionFactory() {
		try {
			Configuration cfg =  new Configuration();
			cfg.configure("persistencia.xml");
			return cfg.buildSessionFactory();
		} catch (Throwable e) {
			System.out.println("Deu pau! Manolo!\n " + e );
			throw new ExceptionInInitializerError();
		}
	}

	public static SessionFactory getSession() {
		return session;
	}
}