package action.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Administrateur;
import metier.Offre;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.DAOOffre;
import daoHibernate.DAOCategorieHibernate;
import daoHibernate.DAOMotClefHibernate;
import daoHibernate.DAOOffreHibernate;

public class AdminAnnulerSignalement extends Action {

	private DAOOffre daoOffre;
	
	public DAOOffre getDaoOffre() {
		return daoOffre;
	}

	public void setDaoOffre(DAOOffre daoOffre) {
		this.daoOffre = daoOffre;
	}
	
	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Administrateur a = new Administrateur(new DAOOffreHibernate(),new DAOCategorieHibernate(),new DAOMotClefHibernate());
		
		int idOffre = Integer.parseInt(request.getParameter("id"));
		
		Offre o = a.getOffre().get(idOffre);
		o.setSuspecte(0);
		a.getOffre().update(o);	
		
		return mapping.getInputForward();
	}

}
