package action.form;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import metier.Internaute;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ActionFormFormuCompte extends ActionForm {
	private static final long serialVersionUID = 5920987576396511807L;

	protected String pseudo = "", nom = "", prenom = "", nomRue = "",
			ville = "", cp = "", email = "", telephone = "", departement = "",
			region = "";

	protected String numeroRue = "";
	protected HttpSession session = null;
	protected Internaute i = null;

	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
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
	 * @return the nom
	 */
	public String getNom() {
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
		return numeroRue;
	}

	/**
	 * @param numeroRue
	 *            the numeroRue to set
	 */
	public void setNumeroRue(String numeroRue) {
		this.numeroRue = numeroRue;
	}

	/**
	 * @return the session
	 */
	public HttpSession getSession() {
		return session;
	}

	/**
	 * @param session
	 *            the session to set
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}

	/**
	 * @return the i
	 */
	public Internaute getI() {
		return i;
	}

	/**
	 * @param i
	 *            the i to set
	 */
	public void setI(Internaute i) {
		this.i = i;
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

		ActionErrors errors = new ActionErrors();
		if (session == null) {
			session = request.getSession();
			try {
				i = (Internaute) session.getAttribute("pseudo");
			} catch (Exception ex) {
				errors.add("", new ActionMessage(""));
			}
		}

		if (getPseudo().trim().isEmpty())
			errors.add("inscription.pseudo.vide", new ActionMessage(
					"inscription.pseudo.vide"));
		if (getNom().trim().isEmpty())
			errors.add("inscription.nom.vide", new ActionMessage(
					"inscription.nom.vide"));
		if (getPrenom().trim().isEmpty())
			errors.add("inscription.prenom.vide", new ActionMessage(
					"inscription.prenom.vide"));
		if (getNumeroRue().trim().isEmpty())
			errors.add("inscription.numrue.vide", new ActionMessage(
					"inscription.numrue.vide"));
		else {
			try {
				Integer.parseInt(getNumeroRue().trim());
			} catch (NumberFormatException nfe) {
				errors.add("inscription.numrue.invalide", new ActionMessage(
						"inscription.numrue.invalide"));
			}
		}

		if (getNomRue().trim().isEmpty())
			errors.add("inscription.nomrue.vide", new ActionMessage(
					"inscription.nomrue.vide"));
		if (getCp().trim().isEmpty())
			errors.add("inscription.cp.vide", new ActionMessage(
					"inscription.cp.vide"));

		String regex = "^[0-9]{5,5}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(getCp().trim());
		if (!matcher.find())
			errors.add("inscription.cp.invalide", new ActionMessage(
					"inscription.cp.invalide"));

		if (getVille().trim().isEmpty())
			errors.add("inscription.ville.vide", new ActionMessage(
					"inscription.ville.vide"));

		if (getEmail().trim().isEmpty())
			errors.add("inscription.mail.vide", new ActionMessage(
					"inscription.mail.vide"));

		regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.(?:[a-zA-Z]{2,2}|com|org|net|edu|gov|mil|biz|info|mobi|name|aero|asia|jobs|museum)$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(getEmail().trim());
		if (!matcher.find())
			errors.add("inscription.mail.invalide", new ActionMessage(
					"inscription.mail.invalide"));

		if (getTelephone().trim().isEmpty())
			errors.add("inscription.tel.vide", new ActionMessage(
					"inscription.tel.vide"));
		regex = "^0\\d\\d{2,2}\\d{2,2}\\d{2,2}\\d{2,2}$";
		pattern = Pattern.compile(regex);
		matcher = pattern.matcher(getTelephone().trim());
		if (!matcher.find())
			errors.add("inscription.tel.invalide", new ActionMessage(
					"inscription.tel.invalide"));

		if (getDepartement().trim().isEmpty())
			errors.add("inscription.dpt.vide", new ActionMessage(
					"inscription.dpt.vide"));

		if (getRegion().trim().isEmpty())
			errors.add("inscription.region.vide", new ActionMessage(
					"inscription.region.vide"));

		return errors;
	}
}
