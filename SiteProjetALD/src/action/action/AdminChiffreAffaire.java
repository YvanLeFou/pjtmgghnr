package action.action;

import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Administrateur;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import daoHibernate.DAOCategorieHibernate;
import daoHibernate.DAOMotClefHibernate;
import daoHibernate.DAOOffreHibernate;

public class AdminChiffreAffaire extends Action {

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Administrateur a = new Administrateur(new DAOOffreHibernate(),new DAOCategorieHibernate(),new DAOMotClefHibernate());
		Calendar calendar = Calendar.getInstance();
		request.getSession().setAttribute("caDerniersMois", a.getCADerniersMois());
		request.getSession().setAttribute("caEnCours", a.getCAMois(calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR)));
		return mapping.findForward("adminChiffreAffaire");
	}

}