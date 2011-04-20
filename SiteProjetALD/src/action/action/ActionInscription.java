package action.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Departement;
import metier.Droit;
import metier.Internaute;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import daoHibernate.DAODepartementHibernate;
import daoHibernate.DAODroitHibernate;
import daoHibernate.DAOInternauteHibernate;

import action.form.ActionFormFormuInscription;

public class ActionInscription extends Action {
	
	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("ici j'inscris");
		//ici il faut enregistrer l'internaute dans la base
		ActionFormFormuInscription f = (ActionFormFormuInscription)form;
		
		String 	nom = f.getNom(),
				prenom = f.getPrenom(), 
				pseudo = f.getPseudo(), 
				mdp = f.getMdp(),
				nomRue = f.getNomRue(), 
				ville = f.getVille(), 
				cp = f.getCp(), 
				telephone = f.getTelephone(), 
				email = f.getEmail();
		
		int numeroRue = Integer.parseInt(f.getNumeroRue());
		
		//les info là sont à récupérer à l'aide de DAO pour le moment constructeur par défaut
		DAODroitHibernate daoDroit = new DAODroitHibernate();
		DAODepartementHibernate daoDep = new DAODepartementHibernate();
		Departement departement = daoDep.get(Integer.parseInt(f.getDepartement()));
		Droit d = daoDroit.get(1);
		
		Internaute i = new Internaute(nom, prenom, pseudo, mdp, numeroRue, nomRue, ville, cp, telephone, email, d, departement);
		DAOInternauteHibernate dao = new DAOInternauteHibernate();
		
		try
		{
			dao.save(i);
			request.getSession().setAttribute("pseudo", i);
		}
		catch(org.hibernate.exception.ConstraintViolationException b)
		{
			ActionMessages erreur = new ActionMessages();
			erreur.add("inscription.pseudo.pris", new ActionMessage("inscription.pseudo.pris"));
			this.addErrors(request, erreur);

			return mapping.findForward("inscription");
		}
		
		return mapping.findForward("index");
	}

}
