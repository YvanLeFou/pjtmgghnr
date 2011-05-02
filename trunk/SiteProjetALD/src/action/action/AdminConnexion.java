package action.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Internaute;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import action.form.ActionFormFormuRapide;
import dao.DAOInternaute;

public class AdminConnexion extends Action 
{
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

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionFormFormuRapide fm = (ActionFormFormuRapide) form;
		
		Internaute i = daoInternaute.get(fm.getPseudo());
		
		ActionForward a = (ActionForward) mapping.findForward("adminAccueil");
		
		if (i != null && i.getMdp().equals(fm.getMdp()) && i.getDroit().getLibelleDroit().equals("administrateur")) 
		{
			request.getSession().setAttribute("pseudo", i);
		}
		else // pas de resultat
		{
			ActionMessages erreur = null;
			erreur = new ActionMessages();
			erreur.add("entete.admin.introuvable", new ActionMessage("entete.admin.introuvable"));
			this.addErrors(request, erreur);
		}
		
		return a;
	}

}

