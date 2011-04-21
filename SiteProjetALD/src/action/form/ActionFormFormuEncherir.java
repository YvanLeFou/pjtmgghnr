package action.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ActionFormFormuEncherir extends ActionForm {
	private static final long serialVersionUID = 5920987576396511807L;
	
	private String enchere = "-1";
	
	private String idOffre;
	
	/**
	 * @return the enchere
	 */
	public String getEnchere() {
		return enchere;
	}

	/**
	 * @param enchere the enchere to set
	 */
	public void setEnchere(String enchere) {
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
		ActionErrors erreurs = new ActionErrors();;
		
		if (!getEnchere().trim().isEmpty())
		{
			double ench = Double.parseDouble(getEnchere());
			
			if (ench < 1.)
				erreurs.add("enchere.invalide", new ActionMessage("enchere.invalide"));
		}
		else
			erreurs.add("enchere.invalide", new ActionMessage("enchere.invalide"));
		
		request.setAttribute("id", idOffre);
		return erreurs;
	}
}
