package daoHibernate;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.DAODepartement;


import metier.Departement;

public class DAODepartementHibernate extends DAOHibernate implements DAODepartement{

	/* (non-Javadoc)
	 * @see daoHibernate.IDAODepartement#delete(metier.Departement)
	 */
	@Override
	public void delete(Departement d) throws Exception {
		Session	session = connect();
		
		session.delete(d);
		d.setIdDepartement(-1);
		
		close(session);
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAODepartement#get(int)
	 */
	@Override
	public Departement get(int IdDep) throws Exception {
		Departement d = null;
		Session	session = connect();
		
		d = (Departement) session.get(Departement.class, IdDep);
		
		close(session);
		return d;
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAODepartement#loadAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<Departement> loadAll() throws Exception {
		ArrayList<Departement>	tab = null;
		Session session = connect();
		
		tab = (ArrayList<Departement>) session.createQuery("FROM Departement")
				.list();
		
		close(session);
		return tab;
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAODepartement#save(metier.Departement)
	 */
	@Override
	public void save(Departement d) throws Exception {
		Session	session = connect();
		
		session.save(d);
		
		close(session);		
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAODepartement#update(metier.Departement)
	 */
	@Override
	public void update(Departement d) throws Exception {
		Session	session = connect();
		
		session.update(d);
		
		close(session);
	}
}
