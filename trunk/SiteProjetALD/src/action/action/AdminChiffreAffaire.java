package action.action;

import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Administrateur;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.DAOOffre;

public class AdminChiffreAffaire extends Action {

	private DAOOffre daoOffre;
	
	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		Administrateur a = new Administrateur();
		a.setOffre(daoOffre);
		Calendar calendar = Calendar.getInstance();
		request.getSession().setAttribute("caDerniersMois", a.getCADerniersMois());
		request.getSession().setAttribute("caEnCours", a.getCACourant(calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR)));
		return mapping.findForward("adminChiffreAffaire");
	}

	public DAOOffre getDaoOffre() {
		return daoOffre;
	}

	public void setDaoOffre(DAOOffre daoOffre) {
		this.daoOffre = daoOffre;
	}

}
