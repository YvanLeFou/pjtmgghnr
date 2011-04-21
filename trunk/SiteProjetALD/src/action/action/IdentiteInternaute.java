package action.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Internaute;
import metier.Offre;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import daoHibernate.DAOOffreHibernate;

import action.form.ActionFormFormuIdentiteInternaute;

public class IdentiteInternaute extends Action {

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionFormFormuIdentiteInternaute f = (ActionFormFormuIdentiteInternaute)form;
		System.out.println(f.getIdOffre());
		DAOOffreHibernate dao = new DAOOffreHibernate();
		Offre o = dao.get(Integer.parseInt(f.getIdOffre()));
		Internaute i = o.getInternaute();
		
		request.setAttribute("annonce", i.getOffre());
		request.setAttribute("internaute", i);
		request.setAttribute("nbVente", i.getOffre().size());
		request.setAttribute("nbAchat", i.getEncherit().size());
		
		return mapping.findForward("identiteInternaute");
	}

}
