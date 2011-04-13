package test;

import java.util.ArrayList;

import metier.Categorie;
import daoHibernate.DAOCategorieHibernate;
import junit.framework.TestCase;


public class TestCategorie extends TestCase{

	public void testSave() throws Exception
	{
		DAOCategorieHibernate dao = new DAOCategorieHibernate();
		dao.save(new Categorie("Vacances"));
		dao.save(new Categorie("Loisirs"));
		dao.save(new Categorie("Vaisselle"));
	}
	
	public void testUpdate() throws Exception
	{
		DAOCategorieHibernate dao = new DAOCategorieHibernate();

		Categorie last = new Categorie("Jardin");
		System.out.println(last);
		dao.save(last);
		System.out.println(last);
		
		last.setLibelle("Exterieur");
		dao.update(last);
		System.out.println(last);
	}
	
	public void testDelete() throws Exception
	{
		DAOCategorieHibernate dao = new DAOCategorieHibernate();
		Categorie cat = dao.get(2);
		System.out.println(cat);
		if (cat != null)
		{
			dao.delete(cat);
			System.out.println(cat);
		}
	}
	
	public void testGet() throws Exception
	{
		DAOCategorieHibernate dao = new DAOCategorieHibernate();
		
		Categorie cat = dao.get(1);
		System.out.println(cat);
	}
	
	public void testLoadAll() throws Exception
	{
		DAOCategorieHibernate dao = new DAOCategorieHibernate();
		
		ArrayList<Categorie> list = dao.loadAll();
		for(Categorie a : list)
			System.out.println(a);
		
	}
	
}
