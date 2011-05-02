package action.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Administrateur;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.DAOCategorie;
import daoHibernate.DAOCategorieHibernate;
import daoHibernate.DAOMotClefHibernate;
import daoHibernate.DAOOffreHibernate;

public class AdminListeCategorie extends Action {

	private DAOCategorie daoCategorie;

	public DAOCategorie getDaoCategorie() {
		return daoCategorie;
	}

	public void setDaoCategorie(DAOCategorie daoCategorie) {
		this.daoCategorie = daoCategorie;
	}
	
	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Administrateur a = new Administrateur();
		a.setCategorie(daoCategorie);
		request.getSession().setAttribute("categories", a.getCategorie().loadAll());
		return mapping.findForward("adminGestionCategories");
	}

}
