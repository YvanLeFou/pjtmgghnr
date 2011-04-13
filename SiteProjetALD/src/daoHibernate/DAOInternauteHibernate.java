package daoHibernate;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.DAOInternaute;


import metier.Internaute;

public class DAOInternauteHibernate extends DAOHibernate implements DAOInternaute{

	/* (non-Javadoc)
	 * @see daoHibernate.IDAODroit#delete(metier.Droit)
	 */
	@Override
	public void delete(Internaute i) throws Exception {
		Session	session = connect();
		
		session.delete(i);
		i.setPseudo(null);
		
		close(session);
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAODroit#get(int)
	 */
	@Override
	public Internaute get(String pseudo) throws Exception {
		Internaute i = null;
		Session	session = connect();
		
		i = (Internaute) session.get(Internaute.class, pseudo);
		
		close(session);
		return i;
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAODroit#loadAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<Internaute> loadAll() throws Exception {
		ArrayList<Internaute>	tab = null;
		Session session = connect();
		
		tab = (ArrayList<Internaute>) session.createQuery("FROM Internaute")
				.list();
		
		close(session);
		return tab;
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAODroit#save(metier.Droit)
	 */
	@Override
	public void save(Internaute i) throws Exception {
		Session	session = connect();
		
		session.save(i);
		
		close(session);		
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAODroit#update(metier.Droit)
	 */
	@Override
	public void update(Internaute i) throws Exception {
		Session	session = connect();
		
		session.update(i);
		
		close(session);
	}

}
