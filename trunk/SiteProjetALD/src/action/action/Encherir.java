package action.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Encherit;
import metier.Internaute;
import metier.Offre;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import daoHibernate.DAOEncheritHibernate;
import daoHibernate.DAOOffreHibernate;

import action.form.ActionFormFormuEncherir;

public class Encherir extends Action {

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionFormFormuEncherir f = (ActionFormFormuEncherir)form;

		DAOEncheritHibernate dao = new DAOEncheritHibernate();
		DAOOffreHibernate daoOffre = new DAOOffreHibernate();
		
		Offre o = daoOffre.get(Integer.parseInt(f.getIdOffre()));
		Encherit e = new Encherit(Double.parseDouble(f.getEnchere()), new Date(), (Internaute)request.getSession().getAttribute("pseudo"), o);
		
		dao.saveOrUpdate(e);
		
		request.getSession().removeAttribute("lastId");
		
		System.out.println(f.getEnchere() + " sur " + f.getIdOffre());
		return mapping.findForward("index");
	}

}
