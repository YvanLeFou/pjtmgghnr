package daoHibernate;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.DAOOffre;

import metier.Internaute;
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

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Offre> findThem(String motClef, int categorie, int departement, double prixMin, double prixMax) throws Exception {
		ArrayList<Offre> list = null;
		
		Session session = connect();
		
		String cplRequete = " and now() between offre.dateDebut and offre.dateFin ";
		
		String from = " from offre ";
		
		if (!motClef.trim().isEmpty())
		{
			cplRequete += " and ( 0 ";
			String[] str = motClef.split(" ");
			for(String s : str)
				cplRequete += " or titre like '%" + s + "%' or descriptif like '%" + s + "%'";
			cplRequete += ")";
		}
		
		if (categorie > 0)
			cplRequete += " and idCategorie = " + categorie;

		if (departement > 0)
			cplRequete += " and idDepartement = " + departement;
		
		if (prixMin > 0)
			cplRequete += " and " + prixMin + " <= miseaprix";
		
		if (prixMax > 0)
		{
			cplRequete += 	" and miseAPrix <= " + prixMax;
		}
		
		String req = "select * " + from + " where 1 " + cplRequete;
		list = (ArrayList<Offre>) session.createSQLQuery(req).addEntity(Offre.class)
				.list();
		
		close(session);
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Offre> getVenteEncours(Internaute i) throws Exception
	{
		ArrayList<Offre> list = null;
		
		Session session = connect();
		
		String sql = "" +
				"select * " +
				"from offre " +
				"where now() between dateDebut and dateFin " +
				"and pseudo = '" + i.getPseudo() + "'";
		
		list = (ArrayList<Offre>) session.createSQLQuery(sql).addEntity(Offre.class)
				.list();
		
		close(session);
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Offre> getHistoriqueVente(Internaute i) throws Exception
	{
		ArrayList<Offre> list = null;
		
		Session session = connect();
		
		String sql = "" +
				"select * " +
				"from offre " +
				"where now() > dateFin " +
				"and pseudo = '" + i.getPseudo() + "'";
		
		list = (ArrayList<Offre>) session.createSQLQuery(sql).addEntity(Offre.class)
				.list();
		
		close(session);
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Offre> getEnchereEncours(Internaute i) throws Exception
	{
		ArrayList<Offre> list = null;
		
		Session session = connect();
		
		String sql = "select * " +
				"from encherit e, offre o " +
				"where e.idoffre = o.idoffre " +
				"and now() between dateDebut and dateFin " + //ou e.date ?? 
				"and e.pseudo = '" + i.getPseudo() + "' " +
				"and e.date = (select max(y.date) " +
				"			     from encherit y " +
				"	             where y.idoffre = e.idoffre " +
				"				 and e.idoffre = o.idoffre) " +
				"and e.prix = (select max(j.prix) " +
				"              from encherit j " +
				"              where j.idoffre = e.idoffre " +
				"              and e.idoffre = o.idoffre)";
		
		list = (ArrayList<Offre>) session.createSQLQuery(sql).addEntity(Offre.class)
				.list();
		
		close(session);
		
		return list;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Offre> getHistoriqueAchat(Internaute i) throws Exception
	{
		ArrayList<Offre> list = null;
		
		Session session = connect();
		
		String sql = "" +
					"select * " +
					"from encherit e, offre o " +
					"where e.idoffre = o.idoffre " +
					"and datefin < now() " + //ou e.date ?? 
					"and e.pseudo = '" + i.getPseudo() + "' " +
					"and e.date = (select max(y.date) " +
					"			     from encherit y " +
					"	             where y.idoffre = e.idoffre " +
					"				 and e.idoffre = o.idoffre) " +
					"and e.prix = (select max(j.prix) " +
					"              from encherit j " +
					"              where j.idoffre = e.idoffre " +
					"              and e.idoffre = o.idoffre)";   
		
		list = (ArrayList<Offre>) session.createSQLQuery(sql).addEntity(Offre.class)
				.list();
		
		close(session);
		
		return list;
	}
}
