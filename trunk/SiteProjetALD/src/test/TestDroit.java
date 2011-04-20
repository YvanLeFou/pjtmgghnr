package test;

import java.util.ArrayList;

import metier.Droit;
import daoHibernate.DAODroitHibernate;
import junit.framework.TestCase;


public class TestDroit extends TestCase{

	public void testSave() throws Exception
	{
		DAODroitHibernate dao = new DAODroitHibernate();
		dao.save(new Droit(-1, "Administrateur"));
		dao.save(new Droit(-1, "Personne majeure"));
	}
	
	public void testUpdate() throws Exception
	{
		DAODroitHibernate dao = new DAODroitHibernate();

		Droit last = new Droit("Personne mineure");
		System.out.println(last);
		dao.save(last);
		System.out.println(last);
		
		last.setLibelleDroit("Enfant");
		dao.update(last);
		System.out.println(last);
	}
	
	public void testDelete() throws Exception
	{
		DAODroitHibernate dao = new DAODroitHibernate();
		Droit d = dao.get(2);
		System.out.println(d);
		if (d != null)
		{
			dao.delete(d);
			System.out.println(d);
		}
	}
	
	public void testGet() throws Exception
	{
		DAODroitHibernate dao = new DAODroitHibernate();
		
		Droit d = dao.get(1);
		System.out.println(d);
	}
	
	public void testLoadAll() throws Exception
	{
		DAODroitHibernate dao = new DAODroitHibernate();
		
		ArrayList<Droit> list = dao.loadAll();
		for(Droit a : list)
			System.out.println(a);
		
	}
	
}
