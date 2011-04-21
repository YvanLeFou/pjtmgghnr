package daoHibernate;

import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;

import metier.Encherit;
import metier.Internaute;
import metier.Offre;
import dao.DAOEncherit;

public class DAOEncheritHibernate extends DAOHibernate implements DAOEncherit {

	@Override
	public void delete(Encherit e) throws Exception {
		Session session = connect();
		
		String hql = "delete from Encherit where pseudo = '" + e.getInternaute().getPseudo() + "' and idOffre = " + e.getOffre().getIdOffre();
        Query query = session.createQuery(hql);
        
        int rowCount = query.executeUpdate();
        System.out.println("Rows affected: " + rowCount);
	}

	@Override
	public Encherit get(Internaute pseudo, Offre idOffre) throws Exception {
		Encherit e = null;
		Session	session = connect();
		
        String hql = "from Encherit where idOffre = "+idOffre.getIdOffre()+" and pseudo = '"+pseudo.getPseudo()+"'";
        Query query = session.createQuery(hql);
        e = (Encherit) query.uniqueResult();
        
		close(session);
		return e;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Encherit> loadAll() throws Exception {
		ArrayList<Encherit>	tab = null;
		Session session = connect();
		
		tab = (ArrayList<Encherit>) session.createQuery("FROM Encherit").list();
		
		close(session);
		return tab;
	}

	@Override
	public void save(Encherit e) throws Exception {
		Session	session = connect();
		
		session.save(e);
		
		close(session);	

	}

	@Override
	public void update(Encherit e) throws Exception {
		Session	session = connect();
		
		session.update(e);
		
		close(session);

	}

	@Override
	public void saveOrUpdate(Encherit e) throws Exception {
		Session	session = connect();
		
		session.saveOrUpdate(e);
		
		close(session);
	}

}
