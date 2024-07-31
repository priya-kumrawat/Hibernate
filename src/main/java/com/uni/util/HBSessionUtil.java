package com.uni.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HBSessionUtil {
	
	public static Session hbConSession() {
		Session session = null;
		try {
			SessionFactory sf = new Configuration().configure().buildSessionFactory();
		    session = sf.openSession();
	
	}catch(Throwable th) {
	System.err.println("Enitial Session creation failed "+th );
	throw new ExceptionInInitializerError(th);
	}
		return session;
	}
	

}
