package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory=buildSessionFactory();
	
	public static SessionFactory buildSessionFactory(){
		try {
			return new  AnnotationConfiguration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// TODO: handle exception
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	public static SessionFactory getsesSessionFactory(){
		return sessionFactory;
	}
	
	
}
