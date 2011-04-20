package test;

import java.util.ArrayList;

import metier.MotClef;
import daoHibernate.DAOMotClefHibernate;
import junit.framework.TestCase;

public class TestMotCle extends TestCase{

	public void testSave() throws Exception
	{
		DAOMotClefHibernate dao = new DAOMotClefHibernate();
		dao.save(new MotClef(-1, "Administrateur"));
		dao.save(new MotClef(-1, "Personne majeure"));
	}
	
	public void testUpdate() throws Exception
	{
		DAOMotClefHibernate dao = new DAOMotClefHibernate();

		MotClef last = new MotClef("Personne mineure");
		System.out.println(last);
		dao.save(last);
		System.out.println(last);
		
		last.setLibelleMotClef("Enfant");
		dao.update(last);
		System.out.println(last);
	}
	
	public void testDelete() throws Exception
	{
		DAOMotClefHibernate dao = new DAOMotClefHibernate();
		MotClef d = dao.get(2);
		System.out.println(d);
		if (d != null)
		{
			dao.delete(d);
			System.out.println(d);
		}
	}
	
	public void testGet() throws Exception
	{
		DAOMotClefHibernate dao = new DAOMotClefHibernate();
		
		MotClef d = dao.get(1);
		System.out.println(d);
	}
	
	public void testLoadAll() throws Exception
	{
		DAOMotClefHibernate dao = new DAOMotClefHibernate();
		
		ArrayList<MotClef> list = dao.loadAll();
		for(MotClef a : list)
			System.out.println(a);
		
	}
	
}
