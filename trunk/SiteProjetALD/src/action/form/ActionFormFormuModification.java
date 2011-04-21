package action.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ActionFormFormuModification extends ActionFormFormuCompte {
	private static final long serialVersionUID = 5920987576396511807L;
	private String mdpActuel = "", mdp = "", mdp2 = "";
	
	/**
	 * @return the mdpActuel
	 */
	public String getMdpActuel() {
		return mdpActuel;
	}
	
	/**
	 * @param mdpActuel the mdpActuel to set
	 */
	public void setMdpActuel(String mdpActuel) {
		this.mdpActuel = mdpActuel;
	}
	
	/**
	 * @return the mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @param mdp the mdp to set
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * @return the mdp2
	 */
	public String getMdp2() {
		return mdp2;
	}

	/**
	 * @param mdp2 the mdp2 to set
	 */
	public void setMdp2(String mdp2) {
		this.mdp2 = mdp2;
	}

	/* (non-Javadoc)
	 * @see action.form.ActionFormFormuCompte#getPseudo()
	 */
	@Override
	public String getPseudo() {
		return i.getPseudo();
	}

	/* (non-Javadoc)
	 * @see action.form.ActionFormFormuCompte#getNom()
	 */
	@Override
	public String getNom() {
		return !nom.equals(this.i.getNom()) && !nom.trim().isEmpty() ? nom : i.getNom();
	}

	/* (non-Javadoc)
	 * @see action.form.ActionFormFormuCompte#getPrenom()
	 */
	@Override
	public String getPrenom() {
		return !prenom.equals(this.i.getPrenom()) && !prenom.trim().isEmpty()  ? prenom : i.getPrenom();
	}

	/* (non-Javadoc)
	 * @see action.form.ActionFormFormuCompte#getNomRue()
	 */
	@Override
	public String getNomRue() {
		return !nomRue.equals(this.i.getNomRue()) && !nomRue.trim().isEmpty()  ? nomRue : i.getNomRue();
	}

	/* (non-Javadoc)
	 * @see action.form.ActionFormFormuCompte#getVille()
	 */
	@Override
	public String getVille() {
		return !ville.equals(this.i.getVille()) && !ville.trim().isEmpty()  ? ville : i.getVille();
	}

	/* (non-Javadoc)
	 * @see action.form.ActionFormFormuCompte#getCp()
	 */
	@Override
	public String getCp() {
		return !cp.equals(this.i.getCp()) && !cp.trim().isEmpty()  ? cp : i.getCp();
	}

	/* (non-Javadoc)
	 * @see action.form.ActionFormFormuCompte#getEmail()
	 */
	@Override
	public String getEmail() {
		return !email.equals(this.i.getEmail()) && !email.trim().isEmpty()  ? email : i.getEmail();
	}

	/* (non-Javadoc)
	 * @see action.form.ActionFormFormuCompte#getTelephone()
	 */
	@Override
	public String getTelephone() {
		return !telephone.equals(this.i.getTelephone()) && !telephone.trim().isEmpty()  ? telephone : i.getTelephone();
	}

	/* (non-Javadoc)
	 * @see action.form.ActionFormFormuCompte#getDepartement()
	 */
	@Override
	public String getDepartement() {
		return "" + (!departement.equals(this.i.getDepartement()) && !departement.trim().isEmpty()  ? departement : i.getDepartement());
	}

	/* (non-Javadoc)
	 * @see action.form.ActionFormFormuCompte#getRegion()
	 */
	@Override
	public String getRegion() {
		return "" + (!region.equals(this.i.getDepartement().getRegion().getIdRegion()) && !region.trim().isEmpty()  ? region : this.i.getDepartement().getRegion().getIdRegion());
	}

	/* (non-Javadoc)
	 * @see action.form.ActionFormFormuCompte#getNumeroRue()
	 */
	@Override
	public String getNumeroRue() {
		return "" + (!numeroRue.equals(this.i.getNumeroRue()) && !numeroRue.trim().isEmpty()  ? numeroRue : i.getNumeroRue());
	}

	/* (non-Javadoc)
	 * @see action.form.ActionFormFormuCompte#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors erreurs = super.validate(mapping, request);
		
		if (erreurs == null)
			erreurs = new ActionErrors();
		
		if (getMdpActuel().trim().isEmpty())
			erreurs.add("inscription.mdp.mod", new ActionMessage("inscription.mdp.mod"));
		
		if (getMdpActuel().trim().isEmpty() &&
				(!getMdp().trim().isEmpty() 
						|| !getMdp2().trim().isEmpty()))
		{
			erreurs.add("inscription.mdp.actuel.vide", new ActionMessage("inscription.mdp.actuel.vide"));
		}
		
		if (!getMdp().trim().equals(getMdp2().trim()))
			erreurs.add("inscription.mdp.identique", new ActionMessage("inscription.mdp.identique"));
		
		return erreurs;
	}

}
