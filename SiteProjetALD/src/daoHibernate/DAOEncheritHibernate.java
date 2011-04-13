package daoHibernate;

import java.util.ArrayList;

import org.hibernate.Session;

import metier.Encherit;
import dao.DAOEncherit;

public class DAOEncheritHibernate extends DAOHibernate implements DAOEncherit {

	@Override
	public void delete(Encherit e) throws Exception {
		Session	session = connect();
		
		session.delete(e);
		e.setInternaute(null);
		e.setOffre(null);
		
		close(session);

	}

	@Override
	public Encherit get(String pseudo, int idOffre) throws Exception {
		Encherit e = null;
		Session	session = connect();
		
		e = (Encherit) session.createQuery("FROM Encherit WHERE pseudo="+pseudo+" AND idOfrre="+idOffre);
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

}
