package action.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ActionFormAdminFormuModifierCategorie extends ActionForm {

	private static final long serialVersionUID = 1L;

	private String idCategorie = "";
	
	private String libelleCategorie = "";
	
	public void setIdCategorie(String idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getIdCategorie() {
		return idCategorie;
	}

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
			erreurs.add("adminGestionCategories.champsVide", new ActionMessage("adminGestionCategories.champsVide"));			
		
		return erreurs;
	}
}
