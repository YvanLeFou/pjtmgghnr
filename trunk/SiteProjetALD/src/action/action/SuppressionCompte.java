package action.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Internaute;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.DAOInternaute;

public class SuppressionCompte extends Action {
	private DAOInternaute daoInternaute;
	
	/**
	 * @return the daoInternaute
	 */
	public DAOInternaute getDaoInternaute() {
		return daoInternaute;
	}

	/**
	 * @param daoInternaute the daoInternaute to set
	 */
	public void setDaoInternaute(DAOInternaute daoInternaute) {
		this.daoInternaute = daoInternaute;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Internaute i = (Internaute) request.getSession().getAttribute("pseudo");
		
		System.err.println(i);
		if (i != null)
		{
			daoInternaute.delete(i);
			System.err.println("apres suppr");
		}
		
		request.getSession().invalidate();
		return mapping.findForward("index");
	}

}
