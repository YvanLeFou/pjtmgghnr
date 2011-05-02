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

import dao.DAOOffre;

public class HistoriqueVente extends Action {
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
		ArrayList<Offre> offre = null;
		
		Internaute i = (Internaute) request.getSession().getAttribute("pseudo");
		offre = daoOffre.getHistoriqueVente(i);
		boolean affiPossible = false;
		
		for(int j = 0; j < offre.size(); j++)
		{
			offre.get(j).setValable(true);
			if (offre.get(j).getEncherit().size() == 0)
			{
				offre.get(j).setValable(false);
				affiPossible = true;
			}
		}
		if (affiPossible)
			request.setAttribute("affi", "vente.invendu");
		request.getSession().setAttribute("listRecherche", offre);
		return mapping.findForward("resultatRecherche");
	}

}
