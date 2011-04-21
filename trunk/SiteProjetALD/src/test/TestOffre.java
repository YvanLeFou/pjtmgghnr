package test;

import java.util.ArrayList;
import java.util.Date;

import metier.Categorie;
import metier.Departement;
import metier.Image;
import metier.Offre;
import daoHibernate.DAOCategorieHibernate;
import daoHibernate.DAODepartementHibernate;
import daoHibernate.DAOOffreHibernate;
import junit.framework.TestCase;


public class TestOffre extends TestCase{

	public void testSave() throws Exception
	{		
		DAOOffreHibernate dao = new DAOOffreHibernate();
		DAODepartementHibernate dep = new DAODepartementHibernate();
		DAOCategorieHibernate cate = new DAOCategorieHibernate();
		Categorie cat = cate.get(1);
		Departement dpt = dep.get(1);
		Offre o = new Offre("salut", "hello", 12, 0, new Date(), new Date(), new Date(), -1, cat, dpt, 0, null);
		
		o.getImage().add(new Image(-1, "machin", o));
		o.getImage().add(new Image(-1, "bidule", o));
		
		dao.save(o);
		dao.save(o);
	}
	
	public void testUpdate() throws Exception
	{
		DAOOffreHibernate dao = new DAOOffreHibernate();

		Offre last = dao.get(1);
		//System.out.println(last);
		//dao.save(last);
		//System.out.println(last);
		
		last.setTitre("Enfant");
		dao.update(last);
		System.out.println(last);
	}
	
	public void testDelete() throws Exception
	{
		DAOOffreHibernate dao = new DAOOffreHibernate();
		DAODepartementHibernate dep = new DAODepartementHibernate();
		DAOCategorieHibernate cate = new DAOCategorieHibernate();
		Categorie cat = cate.get(1);
		Departement dpt = dep.get(1);
		Offre o = new Offre("salut", "hello", 12, 0, new Date(), new Date(), new Date(), -1, cat, dpt, 0, null);
		
		o.getImage().add(new Image(-1, "machin", o));
		o.getImage().add(new Image(-1, "bidule", o));
		
		dao.save(o);
		
		System.out.println(o);
		if (o != null)
		{
			dao.delete(o);
			System.out.println(o);
		}
	}
	
	public void testGet() throws Exception
	{
		DAOOffreHibernate dao = new DAOOffreHibernate();
		
		Offre d = dao.get(2);
		System.err.println(d.getInternaute());
	}
	
	public void testLoadAll() throws Exception
	{
		DAOOffreHibernate dao = new DAOOffreHibernate();
		
		ArrayList<Offre> list = dao.loadAll();
		for(Offre a : list)
			System.out.println(a);
		
	}
	
	public void testFind() throws Exception
	{
		DAOOffreHibernate dao = new DAOOffreHibernate();
		
		ArrayList<Offre> list = dao.findThem("bouillote", 3, 1, 15, -1);
		
		System.out.println(list.size());
		
		for(Offre a : list)
			System.out.println(a);
		
		list = dao.findThem("bouillote", 3, 1, 4, 50);
		
		System.out.println(list.size());
		
		for(Offre a : list)
			System.out.println(a);
	}
}
