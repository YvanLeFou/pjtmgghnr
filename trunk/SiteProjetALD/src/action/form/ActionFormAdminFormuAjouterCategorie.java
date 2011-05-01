package action.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ActionFormAdminFormuAjouterCategorie extends ActionForm {

	private static final long serialVersionUID = 1L;

	private String libelleCategorie = "";

	public void setLibelleCategorie(String libelleCategorie) {
		this.libelleCategorie = libelleCategorie;
	}

	public String getLibelleCategorie() {
		return libelleCategorie;
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
		ActionErrors erreurs = new ActionErrors();
		
		if (getLibelleCategorie().trim().isEmpty())
			erreurs.add("adminGestionCategorie.champsVide", new ActionMessage("adminGestionCategorie.champsVide"));			
		
		return erreurs;
	}	

}
