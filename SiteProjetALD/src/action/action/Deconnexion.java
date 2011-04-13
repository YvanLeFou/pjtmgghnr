package action.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import metier.Categorie;
import metier.Departement;
import metier.Region;

public class Deconnexion extends Action
{
	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ArrayList<Departement> listDep = (ArrayList<Departement>) request.getSession().getAttribute("listDepartement");
		ArrayList<Region> listReg = (ArrayList<Region>) request.getSession().getAttribute("listRegion");
		ArrayList<Categorie> listCat = (ArrayList<Categorie>) request.getSession().getAttribute("listCategorie");
		
		request.getSession().invalidate();
		
		request.getSession().setAttribute("listDepartement", listDep);
		request.getSession().setAttribute("listRegion", listReg);
		request.getSession().setAttribute("listCategorie", listCat);
		return mapping.findForward("index");
	}
}
