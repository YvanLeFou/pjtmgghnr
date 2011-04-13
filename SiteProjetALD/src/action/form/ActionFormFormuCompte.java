package action.form;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import metier.Internaute;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ActionFormFormuCompte extends ActionForm {
	private static final long serialVersionUID = 5920987576396511807L;

	protected String pseudo = "", mdp = "", mdp2 = "", nom = "", prenom = "",
			nomRue = "", ville = "", cp = "", email = "", telephone = "",
			departement = "", region = "";

	protected String numeroRue = "";
	protected HttpSession session = null;
	protected Internaute i = null;
	
	protected String lien = "";
	
	public String getLien()
	{
		return lien;
	}
	
	public void setLien(String lien)
	{
		this.lien = lien;
	}
	
	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		if (i != null)
			return i.getPseudo();
		return pseudo;
	}

	/**
	 * @param pseudo
	 *            the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * @return the mdp1
	 */
	public String getMdp() {
		//if (i != null)
		//	return i.getMdp();
		return mdp;
	}

	/**
	 * @param mdp1
	 *            the mdp1 to set
	 */
	public void setMdp(String mdp1) {
		this.mdp = mdp1;
	}

	/**
	 * @return the mdp2
	 */
	public String getMdp2() {
		return mdp2;
	}

	/**
	 * @param mdp2
	 *            the mdp2 to set
	 */
	public void setMdp2(String mdp2) {
		this.mdp2 = mdp2;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		if (i != null)
			return i.getNom();
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		if (i != null)
			return i.getPrenom();
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the nomRue
	 */
	public String getNomRue() {
		if (i != null)
			return i.getNomRue();
		return nomRue;
	}

	/**
	 * @param nomRue
	 *            the nomRue to set
	 */
	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		if (i != null)
			return i.getVille();
		return ville;
	}

	/**
	 * @param ville
	 *            the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * @return the cp
	 */
	public String getCp() {
		if (i != null)
			return i.getCp();
		return cp;
	}

	/**
	 * @param cp
	 *            the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		if (i != null)
			return i.getEmail();
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		if (i != null)
			return i.getTelephone();
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the departement
	 */
	public String getDepartement() {
		if (i != null)
			return "" + i.getDepartement().getIdDepartement();
		return departement;
	}

	/**
	 * @param departement
	 *            the departement to set
	 */
	public void setDepartement(String departement) {
		this.departement = departement;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		if (i != null)
			return "" + i.getDepartement().getRegion().getIdRegion();
		return region;
	}

	/**
	 * @param region
	 *            the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the numeroRue
	 */
	public String getNumeroRue() {
		if ( i!=null )
			return "" + i.getNumeroRue();
		return numeroRue;
	}

	/**
	 * @param numeroRue
	 *            the numeroRue to set
	 */
	public void setNumeroRue(String numeroRue) {
		this.numeroRue = numeroRue;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts.action.ActionForm#validate(org.apache.struts.action
	 * .ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		
		ActionErrors errors = null;
		if (session == null)
		{
			session = request.getSession();
			try
			{
				i = (Internaute) session.getAttribute("pseudo");
			}
			catch (Exception ex)
			{
				errors = new ActionErrors();
				errors.add("", new ActionMessage(""));
			}
		}
		
		if (getPseudo().trim().isEmpty() || getNom().trim().isEmpty()
				|| getPrenom().trim().isEmpty() || getMdp().trim().isEmpty()
				|| getMdp2().trim().isEmpty() || getNumeroRue().trim().isEmpty()
				|| getNomRue().trim().isEmpty() || getCp().trim().isEmpty()
				|| getVille().trim().isEmpty() || getEmail().trim().isEmpty()
				|| getTelephone().trim().isEmpty()
				|| getDepartement().trim().isEmpty()
				|| getRegion().trim().isEmpty()) {
			
			if (errors == null)
				errors = new ActionErrors();
			
			if (getPseudo().trim().isEmpty())
				errors.add("inscription.pseudo.vide", new ActionMessage("inscription.pseudo.vide"));
			if (getNom().trim().isEmpty())
				errors.add("inscription.nom.vide", new ActionMessage("inscription.nom.vide"));
			if (getPrenom().trim().isEmpty())
				errors.add("inscription.prenom.vide", new ActionMessage("inscription.prenom.vide"));
			if (getMdp().trim().isEmpty())
				errors.add("inscription.mdp.vide", new ActionMessage("inscription.mdp.vide"));
			if (getMdp2().trim().isEmpty())
				errors.add("inscription.mdp2.vide", new ActionMessage("inscription.mdp2.vide"));
			if (getNumeroRue().trim().isEmpty())
				errors.add("inscription.numrue.vide", new ActionMessage("inscription.numrue.vide"));
			else
			{
				try
				{
					Integer.parseInt(getNumeroRue().trim());
				}
				catch(NumberFormatException nfe)
				{
					errors.add("inscription.numrue.invalide", new ActionMessage("inscription.numrue.invalide"));
				}
			}
			
			if (getNomRue().trim().isEmpty())
				errors.add("inscription.nomrue.vide", new ActionMessage("inscription.nomrue.vide"));
			if (getCp().trim().isEmpty())
				errors.add("inscription.cp.vide", new ActionMessage("inscription.cp.vide"));
			if (getVille().trim().isEmpty())
				errors.add("inscription.ville.vide", new ActionMessage("inscription.ville.vide"));
			if (getEmail().trim().isEmpty())
				errors.add("inscription.mail.vide", new ActionMessage("inscription.mail.vide"));
			if (getTelephone().trim().isEmpty())
				errors.add("inscription.tel.vide", new ActionMessage("inscription.tel.vide"));
			if (getDepartement().trim().isEmpty())
				errors.add("inscription.dpt.vide", new ActionMessage("inscription.dpt.vide"));
			if (getRegion().trim().isEmpty())
				errors.add("inscription.region.vide", new ActionMessage("inscription.region.vide"));
		}
		
		if (!getMdp().trim().equals(getMdp2().trim()))
		{
			if (errors == null)
				errors = new ActionErrors();
			errors.add("inscription.mdp.identique", new ActionMessage("inscription.mdp.identique"));
		}
		
		//il faut aussi vérifier que le pseudo n'est pas utilisé
		
		return errors;
	}
}
