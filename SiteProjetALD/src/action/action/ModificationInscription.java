package action.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Departement;
import metier.Internaute;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.DAODepartement;
import dao.DAOInternaute;

import action.form.ActionFormFormuModification;

public class ModificationInscription extends Action {
	private DAOInternaute daoInternaute;
	private DAODepartement daoDepartement;
	
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

	/**
	 * @return the daoDepartement
	 */
	public DAODepartement getDaoDepartement() {
		return daoDepartement;
	}

	/**
	 * @param daoDepartement the daoDepartement to set
	 */
	public void setDaoDepartement(DAODepartement daoDepartement) {
		this.daoDepartement = daoDepartement;
	}

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
		int departement = Integer.parseInt(f.getDepartement());
		
		//les info là sont à récupérer à l'aide de DAO pour le moment constructeur par défaut
		
		Internaute i = (Internaute) request.getSession().getAttribute("pseudo");
		Departement dep = daoDepartement.get(departement);
		
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
			i.setDepartement(dep);
			
			daoInternaute.update(i);
		}
		return mapping.findForward("index");
	}

}
