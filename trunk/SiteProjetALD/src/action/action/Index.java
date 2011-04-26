package action.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Categorie;
import metier.Departement;
import metier.Region;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.DAOCategorie;
import dao.DAODepartement;
import dao.DAORegion;
import daoHibernate.DAOCategorieHibernate;
import daoHibernate.DAODepartementHibernate;
import daoHibernate.DAORegionHibernate;

public class Index extends Action {
	private DAODepartement daoDepartement;
	private DAORegion daoRegion;
	private DAOCategorie daoCategorie;
	
	/**
	 * @return the daoDepartement
	 */
	public DAODepartement getDaoDepartement() {
		return daoDepartement;
	}

	/**
	 * @param daoDepartement the daoDepartement to set
	 */
	public void setDaoDepartement(DAODepartement daoDepartement) {
		this.daoDepartement = daoDepartement;
	}

	/**
	 * @return the daoRegion
	 */
	public DAORegion getDaoRegion() {
		return daoRegion;
	}

	/**
	 * @param daoRegion the daoRegion to set
	 */
	public void setDaoRegion(DAORegion daoRegion) {
		this.daoRegion = daoRegion;
	}

	/**
	 * @return the daoCategorie
	 */
	public DAOCategorie getDaoCategorie() {
		return daoCategorie;
	}

	/**
	 * @param daoCategorie the daoCategorie to set
	 */
	public void setDaoCategorie(DAOCategorie daoCategorie) {
		this.daoCategorie = daoCategorie;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.getSession().setMaxInactiveInterval(Integer.MAX_VALUE);
		
		if (request.getServletContext().getAttribute("listDepartement") == null)
		{
			ArrayList<Departement> listDep = null;
			//DAODepartementHibernate dao = new DAODepartementHibernate();
			listDep = daoDepartement.loadAll();
			request.getServletContext().setAttribute("listDepartement", listDep);
		}
		
		if (request.getServletContext().getAttribute("listCategorie") == null)
		{
			ArrayList<Categorie> listCat = null;
			//DAOCategorieHibernate daoc = new DAOCategorieHibernate();
			listCat = daoCategorie.loadAll();
			request.getServletContext().setAttribute("listCategorie", listCat);
		}
		
		if (request.getServletContext().getAttribute("listRegion") == null)
		{
			ArrayList<Region> listRegion = null;
			//DAORegionHibernate daoReg = new DAORegionHibernate();
			listRegion = daoRegion.loadAll();
			request.getServletContext().setAttribute("listRegion", listRegion);
		}
		
		request.getSession().setAttribute("lastPath", mapping.findForward("index"));
		return mapping.findForward("index");
	}

}
