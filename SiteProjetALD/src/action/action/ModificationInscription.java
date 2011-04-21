package action.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Internaute;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import daoHibernate.DAOInternauteHibernate;

import action.form.ActionFormFormuModification;

public class ModificationInscription extends Action {
	
	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println("ici je modifie");
		//ici il faut enregistrer l'internaute dans la base
		ActionFormFormuModification f = (ActionFormFormuModification)form;
		
		String 	nom = f.getNom(),
				prenom = f.getPrenom(), 
				mdpActuel = f.getMdpActuel(),
				mdp = f.getMdp(),
				/*mdp2 = f.getMdp2(),*/
				nomRue = f.getNomRue(), 
				ville = f.getVille(), 
				cp = f.getCp(), 
				telephone = f.getTelephone(), 
				email = f.getEmail();
		
		int numeroRue = Integer.parseInt(f.getNumeroRue());
		
			//les info là sont à récupérer à l'aide de DAO pour le moment constructeur par défaut
		
		DAOInternauteHibernate dao = new DAOInternauteHibernate();
		Internaute i = (Internaute) request.getSession().getAttribute("pseudo");
		
		System.out.println(f.getNom());
		
		if (i.getMdp().trim().equals(mdpActuel.trim()))
		{
			i.setCp(cp);
			i.setVille(ville);
			i.setTelephone(telephone);
			i.setEmail(email);
			i.setNom(nom);
			i.setPrenom(prenom);
			i.setMdp(mdp.trim().isEmpty() ? mdpActuel : mdp);
			i.setNomRue(nomRue);
			i.setNumeroRue(numeroRue);
			
			dao.update(i);
		}
		return mapping.findForward("index");
	}

}
