package action.action;

import java.util.Date;
import java.util.HashSet;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Categorie;
import metier.Departement;
import metier.Encherit;
import metier.Image;
import metier.Internaute;
import metier.Offre;
import metier.Region;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import daoHibernate.DAOOffreHibernate;

public class IdentiteAnnonce extends Action {

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println(request.getRequestURI());
		
		DAOOffreHibernate dao = new DAOOffreHibernate();
		
		if (request.getSession().getAttribute("lastId") == null)
			request.getSession().setAttribute("lastId", Integer.parseInt(request.getParameter("id")));
		
		int id = (Integer) request.getSession().getAttribute("lastId");
		Offre o = dao.get(id);
		Internaute i = o.getInternaute();
		
		request.setAttribute("annonce", o);
		request.setAttribute("internaute", i);
		return mapping.findForward("identiteAnnonce");
	}

}
