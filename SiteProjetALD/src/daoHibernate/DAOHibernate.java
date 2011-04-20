package daoHibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DAOHibernate {

	private static SessionFactory sessionFactory = null;

	public Session connect() throws Exception {
		if (sessionFactory == null)
			sessionFactory = new Configuration().configure()
					.buildSessionFactory();

		Session session = sessionFactory.openSession();
		session.beginTransaction();

		return session;
	}

	public void cancel(Session session) {
		session.getTransaction().rollback();
		session.close();
	}

	public void close(Session session) throws Exception {
		session.getTransaction().commit();
		session.close();
	}
}
