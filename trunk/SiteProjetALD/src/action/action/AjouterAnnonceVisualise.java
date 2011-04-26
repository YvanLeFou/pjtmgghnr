package action.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Internaute;
import metier.Offre;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.DAOOffre;
import daoHibernate.DAOOffreHibernate;

public class AjouterAnnonceVisualise extends Action {
	private DAOOffre daoOffre;
	
	/**
	 * @return the daoOffre
	 */
	public DAOOffre getDaoOffre() {
		return daoOffre;
	}

	/**
	 * @param daoOffre the daoOffre to set
	 */
	public void setDaoOffre(DAOOffre daoOffre) {
		this.daoOffre = daoOffre;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Offre o = (Offre) request.getSession().getAttribute("nouvelleOffre");
		
		daoOffre.save(o);
		
		request.getSession().removeAttribute("nouvelleOffre");
		
		return mapping.findForward("index");
	}

}
