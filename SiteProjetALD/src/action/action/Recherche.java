package action.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Offre;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import action.form.ActionFormFormuRecherche;

import dao.DAOOffre;

public class Recherche extends Action {
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
		ActionFormFormuRecherche f = (ActionFormFormuRecherche)form;
		
		String	motClef = f.getMotclef();
		int 	categ = f.getCategorie().trim().isEmpty() ? -1 : Integer.parseInt(f.getCategorie()),
				dep = f.getDepartementSelect().trim().isEmpty() ? -1 : Integer.parseInt(f.getDepartementSelect());
		double	prixMin = f.getMin().trim().isEmpty() ? -1 : Double.parseDouble(f.getMin()),
				prixMax = f.getMax().trim().isEmpty() ? -1 : Double.parseDouble(f.getMax());
		
		ArrayList<Offre> offre = daoOffre.findThem(motClef, categ, dep, prixMin, prixMax);
		
		request.getSession().setAttribute("listRecherche", offre);
		request.getSession().setAttribute("lastPath", mapping.findForward("resultatRecherche"));
		return mapping.findForward("resultatRecherche");
	}

}
