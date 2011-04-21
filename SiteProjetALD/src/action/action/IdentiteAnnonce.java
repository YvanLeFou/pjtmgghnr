package action.action;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Encherit;
import metier.Internaute;
import metier.Offre;

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
		
		//if (request.getSession().getAttribute("lastId") == null)
		//	request.getSession().setAttribute("lastId", Integer.parseInt(request.getParameter("id")));
		
		//int id = (Integer) request.getSession().getAttribute("lastId");
		int id;
		
		try
		{
			id = Integer.parseInt(request.getParameter("id")); 
		}
		catch(Exception e)
		{
			id = Integer.parseInt((String) request.getAttribute("id"));
		}
		
		Offre o = dao.get(id);
		Internaute i = o.getInternaute();
		
		Iterator<Encherit> it = o.getEncherit().iterator();
		Encherit save = null;
		if (it.hasNext())
		{
			save = it.next();
			while(it.hasNext())
			{
				Encherit e = it.next();
				
				if (e != null && save != null && e.getDate().compareTo(save.getDate()) > 0)
					save = e;
			}
		}
		
		request.setAttribute("annonce", o);
		request.setAttribute("enchere", save);
		request.setAttribute("internaute", i);
		return mapping.findForward("identiteAnnonce");
	}

}
