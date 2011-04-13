package daoHibernate;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.DAOMotClef;


import metier.MotClef;

public class DAOMotClefHibernate extends DAOHibernate implements DAOMotClef{

	/* (non-Javadoc)
	 * @see daoHibernate.IDAOMotClef#delete(metier.MotClef)
	 */
	@Override
	public void delete(MotClef mc) throws Exception {
		Session	session = connect();
		
		session.delete(mc);
		mc.setIdMotClef(-1);
		
		close(session);
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAOMotClef#get(int)
	 */
	@Override
	public MotClef get(int IdMotClef) throws Exception {
		MotClef	mc = null;
		Session	session = connect();
		
		mc = (MotClef) session.get(MotClef.class, IdMotClef);
		
		close(session);
		return mc;
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAOMotClef#loadAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<MotClef> loadAll() throws Exception {
		ArrayList<MotClef>	tab = null;
		Session session = connect();
		
		tab = (ArrayList<MotClef>) session.createQuery("FROM Motclef")
				.list();
		
		close(session);
		return tab;
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAOMotClef#save(metier.MotClef)
	 */
	@Override
	public void save(MotClef mc) throws Exception {
		Session	session = connect();
		
		session.save(mc);
		
		close(session);		
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAOMotClef#update(metier.MotClef)
	 */
	@Override
	public void update(MotClef mc) throws Exception {
		Session	session = connect();
		
		session.update(mc);
		
		close(session);
	}
}
