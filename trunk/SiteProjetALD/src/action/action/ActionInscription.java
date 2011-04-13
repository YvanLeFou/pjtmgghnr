package action.action;

import java.util.HashSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Departement;
import metier.Droit;
import metier.Encherit;
import metier.Internaute;
import metier.Offre;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

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
		Droit droit = new Droit();
		Departement departement = new Departement(f.getDepartement());
		HashSet<Encherit> encherit = new HashSet<Encherit>();
		HashSet<Offre> offre = new HashSet<Offre>();
		
		Internaute i = new Internaute(nom, prenom, pseudo, mdp, numeroRue, nomRue, ville, cp, telephone, email, droit, departement, encherit, offre);
		
		System.out.println(i);
		return mapping.findForward("index");
	}

}
