package action.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Offre;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import daoHibernate.DAOOffreHibernate;

import action.form.ActionFormFormuSignaler;

public class Signaler extends Action {

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionFormFormuSignaler f = (ActionFormFormuSignaler) form;
		DAOOffreHibernate dao = new DAOOffreHibernate();
		Offre o = dao.get(Integer.parseInt(f.getIdOffre()));
		
		o.setSuspecte(o.getSuspecte() + 1);
		
		dao.update(o);
		
		RequestDispatcher rd = request.getRequestDispatcher("recherche.do");
		rd.forward(request, response);
		return mapping.findForward("index");
	}

}
