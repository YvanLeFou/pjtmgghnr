package daoHibernate;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.DAOOffre;


import metier.Offre;

public class DAOOffreHibernate extends DAOHibernate implements DAOOffre{

	/* (non-Javadoc)
	 * @see daoHibernate.IDAODepartement#delete(metier.Departement)
	 */
	@Override
	public void delete(Offre o) throws Exception {
		Session	session = connect();
		
		session.delete(o);
		o.setIdOffre(-1);
		
		close(session);
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAODepartement#get(int)
	 */
	@Override
	public Offre get(int IdOffre) throws Exception {
		Offre o = null;
		Session	session = connect();
		
		o = (Offre) session.get(Offre.class, IdOffre);
		
		close(session);
		return o;
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAODepartement#loadAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<Offre> loadAll() throws Exception {
		ArrayList<Offre>	tab = null;
		Session session = connect();
		
		tab = (ArrayList<Offre>) session.createQuery("FROM Offre")
				.list();
		
		close(session);
		return tab;
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAODepartement#save(metier.Departement)
	 */
	@Override
	public void save(Offre o) throws Exception {
		Session	session = connect();
		
		session.save(o);
		
		close(session);		
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAODepartement#update(metier.Departement)
	 */
	@Override
	public void update(Offre o) throws Exception {
		Session	session = connect();
		
		session.update(o);
		
		close(session);
	}
}
