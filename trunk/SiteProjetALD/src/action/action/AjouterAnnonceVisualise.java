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

import daoHibernate.DAOOffreHibernate;

public class AjouterAnnonceVisualise extends Action {

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Offre o = (Offre) request.getSession().getAttribute("nouvelleOffre");
		
		DAOOffreHibernate dao = new DAOOffreHibernate();
		
		dao.save(o);
		
		request.getSession().removeAttribute("nouvelleOffre");
		
		return mapping.findForward("index");
	}

}
