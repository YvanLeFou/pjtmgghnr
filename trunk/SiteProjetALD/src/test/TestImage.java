package test;

import java.util.ArrayList;

import metier.Image;
import metier.Offre;
import daoHibernate.DAOImageHibernate;
import junit.framework.TestCase;


public class TestImage extends TestCase{

	public void testSave() throws Exception
	{
		DAOImageHibernate dao = new DAOImageHibernate();
		Offre o = new Offre();
		dao.save(new Image(-1, "Administrateur", o));
		dao.save(new Image(-1, "Personne majeure", o));
	}
	
	public void testUpdate() throws Exception
	{
		DAOImageHibernate dao = new DAOImageHibernate();

		Image last = new Image("Personne mineure");
		System.out.println(last);
		dao.save(last);
		System.out.println(last);
		
		last.setLibelleImage("Enfant");
		dao.update(last);
		System.out.println(last);
	}
	
	public void testDelete() throws Exception
	{
		DAOImageHibernate dao = new DAOImageHibernate();
		Image d = dao.get(13);
		System.out.println(d);
		if (d != null)
		{
			dao.delete(d);
			System.out.println(d);
		}
	}
	
	public void testGet() throws Exception
	{
		DAOImageHibernate dao = new DAOImageHibernate();
		
		Image d = dao.get(14);
		System.out.println(d);
	}
	
	public void testLoadAll() throws Exception
	{
		DAOImageHibernate dao = new DAOImageHibernate();
		
		ArrayList<Image> list = dao.loadAll();
		for(Image a : list)
			System.out.println(a);
		
	}
	
}
