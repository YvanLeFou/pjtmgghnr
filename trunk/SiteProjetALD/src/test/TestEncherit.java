package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

public class TestEncherit extends TestCase{
	public Internaute create(String pseudo) throws Exception
	{
		DAODroitHibernate dro = new DAODroitHibernate();
		Droit d = dro.get(1);
		DAODepartementHibernate dep = new DAODepartementHibernate();
		Departement dpt = dep.get(1);
		HashSet<Offre> of = new HashSet<Offre>();
		
		Set<Image> img = new HashSet<Image>();
		DAOCategorieHibernate cate = new DAOCategorieHibernate();
		Categorie cat = cate.get(1);
		
		Set<Encherit> en = new HashSet<Encherit>();
		
		Internaute i = new Internaute("Reitz", "Nicolas", pseudo, "truc", 28, "rue des pommiers", "hayange", "57700", "0382859251", "nicolas.reitz@gmx.fr", d, dpt);
		
		Offre o = new Offre("salut", "hello", 12., 0, new Date(), new Date(), new Date(), -1, cat, dpt, 0, i);
		
		img.add(new Image(-1, "machin", o));
		img.add(new Image(-1, "bidule", o));
		o.setImage(img);
		of.add(o);
		
		i.setOffre(of);
		i.setEncherit(en);
		
		System.err.println("nbEnchere" + i.getEncherit().size());
		System.err.println("nbOffre" + i.getOffre().size());
		
		return i;
	}
	
	public void testSave() throws Exception
	{
		DAOInternauteHibernate dao = new DAOInternauteHibernate();
		Internaute i = dao.get("Banbi");
		if (i == null)
		{
			i = create("Banbi");
			dao.save(i);
		}
		System.out.println(i.getOffre().size());
		Offre o = i.getOffre().iterator().next();
		Encherit e = new Encherit(6., i, o);
		i.getEncherit().add(e);
		dao.update(i);
	}
	
	public void testUpdate() throws Exception
	{
		DAOInternauteHibernate dao = new DAOInternauteHibernate();
		
		Internaute i = dao.get("Banbi");
		Encherit e = new Encherit(5., i, i.getOffre().iterator().next());
		e.setPrix(12.);
		
		DAOEncheritHibernate enc = new DAOEncheritHibernate();
		enc.update(e);
	}
	
	public void testDelete() throws Exception
	{
		DAOInternauteHibernate dao = new DAOInternauteHibernate();
		Internaute o = create("Nico");

		dao.save(o);
		if (o != null)
		{
			dao.delete(o);
			//System.out.println(o);
		}
	}
	
	public void testGet() throws Exception
	{
		DAOInternauteHibernate dao = new DAOInternauteHibernate();
		DAOEncheritHibernate daoe = new DAOEncheritHibernate();
		Internaute i = dao.get("Bobo");
		Offre o = i.getEncherit().iterator().next().getOffre();
		Encherit e = daoe.get(i, o);
		System.err.println(e.getInternaute() + " \n" + e.getOffre() + " " + e.getInternaute());
	}
	
	public void testLoadAll() throws Exception
	{
		DAOEncheritHibernate dao = new DAOEncheritHibernate();
		
		ArrayList<Encherit> list = dao.loadAll();
		for(Encherit a : list)
			System.out.println(a.getInternaute() + " " + a.getOffre() + " => " + a.getPrix());
		
	}
}
