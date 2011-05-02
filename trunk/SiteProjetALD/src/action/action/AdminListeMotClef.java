package action.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Administrateur;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.DAOMotClef;

public class AdminListeMotClef extends Action {

	private DAOMotClef daoMotClef;
	
	public DAOMotClef getDaoMotClef() {
		return daoMotClef;
	}

	public void setDaoMotClef(DAOMotClef daoMotClef) {
		this.daoMotClef = daoMotClef;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Administrateur a = new Administrateur();
		a.setMotclef(daoMotClef);
		request.getSession().setAttribute("motsClefs", a.getMotclef().loadAll());
		return mapping.findForward("adminGestionMotsClefs");
	}
}
