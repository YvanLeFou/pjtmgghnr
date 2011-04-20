package action.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Departement;
import metier.Internaute;
import metier.Region;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import daoHibernate.DAOInternauteHibernate;

import action.form.ActionFormFormuRapide;

public class Connexion extends Action 
{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionFormFormuRapide fm = (ActionFormFormuRapide) form;
		
		DAOInternauteHibernate dao = new DAOInternauteHibernate();
		Internaute i = dao.get(fm.getPseudo());
		
		if (i != null && i.getMdp().equals(fm.getMdp())) 
		{
			request.getSession().setAttribute("pseudo", i);
		}
		else // pas de resultat
		{
			ActionMessages erreur = null;
			erreur = new ActionMessages();
			erreur.add("entete.client.introuvable", new ActionMessage("entete.client.introuvable"));
			this.addErrors(request, erreur);
		}
		
		return mapping.findForward("index");
	}

}
