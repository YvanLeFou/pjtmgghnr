package test;

import java.util.ArrayList;

import metier.Departement;
import metier.Region;
import daoHibernate.DAODepartementHibernate;
import daoHibernate.DAORegionHibernate;
import junit.framework.TestCase;


public class TestDepartementRegion extends TestCase{

	public void testSave() throws Exception
	{
		Region r = new Region("Lorraine");
		new Departement(57,"Moselle",r);
		
		//DAODepartementHibernate daoD = new DAODepartementHibernate();
		//DAORegionHibernate daoR = new DAORegionHibernate();
		
		//daoR.save(r);
	}
	
	public void testUpdate() throws Exception
	{
		Region r = new Region("AlsaceAAAA");
		Departement d1= new Departement(67,"Bas Rhin",r);
		
		//DAODepartementHibernate daoD = new DAODepartementHibernate();
		//DAORegionHibernate daoR = new DAORegionHibernate();
		
		System.out.println(r);
		//daoR.save(r);
		
		System.out.println(d1);
		//daoD.save(d1);
		
		r.setLibelle("Alsace");
		//daoR.update(r);
		System.out.println(r);
	}
	
	public void testDelete() throws Exception
	{

		DAORegionHibernate daoR = new DAORegionHibernate();
		
		Region r = daoR.get(1);
		System.out.println(r);
		if (r != null)
		{
			//daoR.delete(r);
			System.out.println(r);
		}
	}
	
	
	public void testLoadAll() throws Exception
	{
		DAODepartementHibernate daoD = new DAODepartementHibernate();
		DAORegionHibernate daoR = new DAORegionHibernate();
		
		ArrayList<Departement> listD = daoD.loadAll();
		for(Departement a : listD)
			System.out.println(a);
		
		Region l = daoR.get(1);
		System.out.println(l.getListeDepartements());
		
	}
}
