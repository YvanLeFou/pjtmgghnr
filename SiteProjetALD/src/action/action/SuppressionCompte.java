package action.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Internaute;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import daoHibernate.DAOInternauteHibernate;

public class SuppressionCompte extends Action {

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DAOInternauteHibernate dao = new DAOInternauteHibernate();
		Internaute i = (Internaute) request.getSession().getAttribute("pseudo");
		
		System.err.println(i);
		if (i != null)
		{
			dao.delete(i);
			System.err.println("apres suppr");
		}
		
		request.getSession().invalidate();
		return mapping.findForward("index");
	}

}
