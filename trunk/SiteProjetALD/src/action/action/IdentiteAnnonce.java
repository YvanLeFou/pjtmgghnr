package action.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Internaute;
import metier.Offre;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.DAOOffre;

public class IdentiteAnnonce extends Action {
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
		System.out.println(request.getRequestURI());
		
		//if (request.getSession().getAttribute("lastId") == null)
		//	request.getSession().setAttribute("lastId", Integer.parseInt(request.getParameter("id")));
		
		//int id = (Integer) request.getSession().getAttribute("lastId");
		int id;
		/*try
		{*/
		if (request.getParameter("id") != null)
			id = Integer.parseInt(request.getParameter("id"));
		else
			id = (Integer) request.getSession().getAttribute("id");
		/*}
		catch(Exception e)
		{
			id = Integer.parseInt((String) request.getAttribute("id"));
		}*/
		
		Offre o = daoOffre.get(id);
		Internaute i = o.getInternaute();
				
		request.setAttribute("annonce", o);
		request.setAttribute("internaute", i);
		request.setAttribute("dateAujourdhui", (new Date()).compareTo(o.getDateFin()));
		
		//request.getSession().setAttribute("lastPath", mapping.findForward("identiteAnnonce"));
		return mapping.findForward("identiteAnnonce");
	}
}
