package test;

import java.util.ArrayList;
import java.util.Date;

import metier.Categorie;
import metier.Departement;
import metier.Droit;
import metier.Encherit;
import metier.Image;
import metier.Internaute;
import metier.Offre;
import daoHibernate.DAOCategorieHibernate;
import daoHibernate.DAODepartementHibernate;
import daoHibernate.DAODroitHibernate;
import daoHibernate.DAOEncheritHibernate;
import daoHibernate.DAOInternauteHibernate;
import junit.framework.TestCase;


public class TestInternaute extends TestCase{

	public Internaute create(String pseudo) throws Exception
	{
		DAODroitHibernate dro = new DAODroitHibernate();
		Droit d = dro.get(1);
		DAODepartementHibernate dep = new DAODepartementHibernate();
		Departement dpt = dep.get(1);
		
		DAOCategorieHibernate cate = new DAOCategorieHibernate();
		Categorie cat = cate.get(1);
		
		Internaute i = new Internaute("Reitz", "Nicolas", pseudo, "truc", 28, "rue des pommiers", "hayange", "57700", "0382859251", "nicolas.reitz@gmx.fr", d, dpt);
		
		Offre o = new Offre("salut", "hello", 12, 0, new Date(), new Date(), new Date(), -1, cat, dpt, 0, i);
		o.getImage().add(new Image(-1, "bidule", o));
		o.getImage().add(new Image(-1, "truc", o));
		
		Encherit e = new Encherit(3., new Date(), i, o);
		o.getEncherit().add(e);
		i.getEncherit().add(e);
		
		i.getOffre().add(o);
		
		System.err.println(i);
		
		return i;
	}
	
	public void testSave() throws Exception
	{
		DAOInternauteHibernate dao = new DAOInternauteHibernate();
		Internaute i = create("Bobo");
		dao.save(i);
		i = dao.get("Bobo");
		System.err.println("la = " + i);
	}
	
	public void testUpdate() throws Exception
	{
		DAOInternauteHibernate dao = new DAOInternauteHibernate();
		DAODepartementHibernate dep = new DAODepartementHibernate();
		Departement dpt = dep.get(1);
		
		DAOCategorieHibernate cate = new DAOCategorieHibernate();
		Categorie cat = cate.get(1);
		
		Internaute i = create("Bobby");
		
		dao.save(i);
		
		Offre o = new Offre("truc", "hello", 12, 0, new Date(), new Date(), new Date(), -1, cat, dpt, 0, i);
		o.getImage().add(new Image(-1, "bidule", o));
		o.getImage().add(new Image(-1, "truc", o));
		
		Encherit e = new Encherit(3., new Date(), i, o);
		o.getEncherit().add(e);
		i.getEncherit().add(e);
		
		i.getOffre().add(o);
		
		i.setDepartement(dep.get(2));
		dao.update(i);
	}
	
	public void testDelete() throws Exception
	{
		DAOInternauteHibernate dao = new DAOInternauteHibernate();
		Internaute o = create("Nico");
		Internaute i = dao.get("Bobby");
		DAOEncheritHibernate daoe = new DAOEncheritHibernate();
		System.err.println("la : " + i);
		Encherit e = i.getEncherit().iterator().next();
		
		dao.save(o);
		if (o != null)
		{
			dao.delete(o);
			daoe.delete(e);
			//System.out.println(o);
		}
	}
	
	public void testGet() throws Exception
	{
		DAOInternauteHibernate dao = new DAOInternauteHibernate();
		DAOEncheritHibernate daoe = new DAOEncheritHibernate();
		System.err.println(dao.get("Nico"));
		
		Internaute i = dao.get("Bobby");
		
		Encherit e = i.getEncherit().iterator().next();
		
		System.err.println(daoe.get(e.getInternaute(), e.getOffre()));
	}
	
	public void testLoadAll() throws Exception
	{
		DAOInternauteHibernate dao = new DAOInternauteHibernate();
		
		ArrayList<Internaute> list = dao.loadAll();
		for(Internaute a : list)
			System.err.println(a);
	}
	
}
