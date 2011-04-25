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
		
		int nbVente = dao.getHistoriqueVente(i).size(),
		nbAchat = dao.getHistoriqueAchat(i).size();
		
		ArrayList<Offre> list = dao.getVenteEncours(i);
		
		request.setAttribute("annonce", list);
		request.setAttribute("internaute", i);
		request.setAttribute("nbVente", nbVente);
		request.setAttribute("nbAchat", nbAchat);
		
		return mapping.findForward("identiteInternaute");
	}

}
