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

import dao.DAOInternaute;

import action.form.ActionFormFormuRapide;

public class Connexion extends Action 
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

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionFormFormuRapide fm = (ActionFormFormuRapide) form;
		
		Internaute i = daoInternaute.get(fm.getPseudo());
		
		ActionForward a = (ActionForward) (request.getSession().getAttribute("lastPath") != null ? request.getSession().getAttribute("lastPath") : mapping.findForward("index"));
		
		if (i != null)
			System.out.println(i.getPseudo()+".equals("+fm.getPseudo()+")");
		
		if (i != null && i.getMdp().equals(fm.getMdp()) && i.getPseudo().equals(fm.getPseudo())) 
		{
			request.getSession().setAttribute("pseudo", i);
			
			if (request.getSession().getAttribute("formEncherir") != null)
			{
				request.setAttribute("encherir", request.getSession().getAttribute("formEncherir"));
				request.getSession().removeAttribute("formEncherir");
			}
		}
		else // pas de resultat
		{
			ActionMessages erreur = null;
			erreur = new ActionMessages();
			erreur.add("entete.client.introuvable", new ActionMessage("entete.client.introuvable"));
			this.addErrors(request, erreur);
		}
		
		return a;
	}

}
