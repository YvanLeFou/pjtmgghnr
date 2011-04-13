package daoHibernate;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.DAORegion;


import metier.Region;

public class DAORegionHibernate extends DAOHibernate implements DAORegion{

	public void delete(Region r) throws Exception {
		Session	session = connect();
		
		session.delete(r);
		r.setIdRegion(-1);
		
		close(session);
	}

	public Region get(int IdRegion) throws Exception {
		Region r = null;
		Session	session = connect();
		
		r = (Region) session.get(Region.class, IdRegion);
		
		close(session);
		return r;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Region> loadAll() throws Exception {
		ArrayList<Region>	tab = null;
		Session session = connect();
		
		tab = (ArrayList<Region>) session.createQuery("FROM Region")
				.list();
		
		close(session);
		return tab;
	}

	public void save(Region r) throws Exception {
		Session	session = connect();
		
		session.save(r);
		
		close(session);	
	}

	public void update(Region r) throws Exception {
		Session	session = connect();
		
		session.update(r);
		
		close(session);
	}
}
