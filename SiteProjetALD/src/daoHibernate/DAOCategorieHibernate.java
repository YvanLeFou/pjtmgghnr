package daoHibernate;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.DAOCategorie;


import metier.Categorie;

public class DAOCategorieHibernate extends DAOHibernate implements DAOCategorie{

	/* (non-Javadoc)
	 * @see daoHibernate.IDAOCategorie#delete(metier.Categorie)
	 */
	@Override
	public void delete(Categorie categorie) throws Exception {
		Session	session = connect();
		
		session.delete(categorie);
		categorie.setIdCategorie(-1);
		
		close(session);
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAOCategorie#get(int)
	 */
	@Override
	public Categorie get(int IdCategorie) throws Exception {
		Categorie	categorie = null;
		Session	session = connect();
		
		categorie = (Categorie) session.get(Categorie.class, IdCategorie);
		
		close(session);
		return categorie;
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAOCategorie#loadAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<Categorie> loadAll() throws Exception {
		ArrayList<Categorie>	tab = null;
		Session session = connect();
		
		tab = (ArrayList<Categorie>) session.createQuery("FROM Categorie")
				.list();
		
		close(session);
		return tab;
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAOCategorie#save(metier.Categorie)
	 */
	@Override
	public void save(Categorie categorie) throws Exception {
		Session	session = connect();
		
		session.save(categorie);
		
		close(session);		
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAOCategorie#update(metier.Categorie)
	 */
	@Override
	public void update(Categorie categorie) throws Exception {
		Session	session = connect();
		
		session.update(categorie);
		
		close(session);
	}
}
