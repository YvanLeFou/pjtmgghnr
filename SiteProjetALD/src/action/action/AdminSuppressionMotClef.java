package action.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Administrateur;
import metier.Internaute;
import metier.MotClef;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import daoHibernate.DAOCategorieHibernate;
import daoHibernate.DAOMotClefHibernate;
import daoHibernate.DAOOffreHibernate;

public class AdminSuppressionMotClef extends Action {

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Administrateur a = new Administrateur(new DAOOffreHibernate(),new DAOCategorieHibernate(),new DAOMotClefHibernate());
		
		int idMotClef = Integer.parseInt(request.getParameter("id"));
		
		MotClef mc = a.getMotclef().get(idMotClef);
		a.getMotclef().delete(mc);	
		
		return mapping.findForward("adminGestionMotsClefs");
	}

}
