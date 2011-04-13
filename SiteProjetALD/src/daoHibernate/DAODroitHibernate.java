package daoHibernate;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.DAODroit;


import metier.Droit;

public class DAODroitHibernate extends DAOHibernate implements DAODroit{

	/* (non-Javadoc)
	 * @see daoHibernate.IDAODroit#delete(metier.Droit)
	 */
	@Override
	public void delete(Droit d) throws Exception {
		Session	session = connect();
		
		session.delete(d);
		d.setIdDroit(-1);
		
		close(session);
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAODroit#get(int)
	 */
	@Override
	public Droit get(int IdDroit) throws Exception {
		Droit d = null;
		Session	session = connect();
		
		d = (Droit) session.get(Droit.class, IdDroit);
		
		close(session);
		return d;
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAODroit#loadAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<Droit> loadAll() throws Exception {
		ArrayList<Droit>	tab = null;
		Session session = connect();
		
		tab = (ArrayList<Droit>) session.createQuery("FROM Droit")
				.list();
		
		close(session);
		return tab;
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAODroit#save(metier.Droit)
	 */
	@Override
	public void save(Droit d) throws Exception {
		Session	session = connect();
		
		session.save(d);
		
		close(session);		
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAODroit#update(metier.Droit)
	 */
	@Override
	public void update(Droit d) throws Exception {
		Session	session = connect();
		
		session.update(d);
		
		close(session);
	}

}
