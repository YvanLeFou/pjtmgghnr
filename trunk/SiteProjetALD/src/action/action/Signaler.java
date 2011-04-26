package action.action;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Offre;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.DAOOffre;

import action.form.ActionFormFormuSignaler;

public class Signaler extends Action {
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
		ActionFormFormuSignaler f = (ActionFormFormuSignaler) form;
		Offre o = daoOffre.get(Integer.parseInt(f.getIdOffre()));
		
		o.setSuspecte(o.getSuspecte() + 1);
		
		daoOffre.update(o);
		
		RequestDispatcher rd = request.getRequestDispatcher("recherche.do");
		rd.forward(request, response);
		return mapping.findForward("index");
	}

}
