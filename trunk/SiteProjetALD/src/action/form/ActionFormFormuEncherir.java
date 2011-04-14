package action.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ActionFormFormuEncherir extends ActionForm {
	private static final long serialVersionUID = 5920987576396511807L;
	
	private double enchere = -1;
	
	private String idOffre;
	
	/**
	 * @return the enchere
	 */
	public double getEnchere() {
		return enchere;
	}

	/**
	 * @param enchere the enchere to set
	 */
	public void setEnchere(double enchere) {
		this.enchere = enchere;
	}

	/**
	 * @return the idOffre
	 */
	public String getIdOffre() {
		return idOffre;
	}

	/**
	 * @param idOffre the idOffre to set
	 */
	public void setIdOffre(String idOffre) {
		this.idOffre = idOffre;
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
		ActionErrors erreurs = null;
		
		if (getEnchere() < 1)
		{
			erreurs = new ActionErrors();
			erreurs.add("enchere.invalide", new ActionMessage("enchere.invalide"));
		}
		
		return erreurs;
	}
}
