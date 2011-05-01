package action.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ActionFormAdminFormuModifierMotClef extends ActionForm {

	private static final long serialVersionUID = 1L;

	private String idMotClef = "";
	
	private String libelleMotClef = "";
	
	public void setIdMotClef(String idMotClef) {
		this.idMotClef = idMotClef;
	}

	public String getIdMotClef() {
		return idMotClef;
	}
	
	public void setLibelleMotClef(String libelleMotClef) {
		this.libelleMotClef = libelleMotClef;
	}

	public String getLibelleMotClef() {
		return libelleMotClef;
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
		
		if (getLibelleMotClef().trim().isEmpty())
			erreurs.add("adminGestionCategories.champsVide", new ActionMessage("adminGestionCategories.champsVide"));			
		
		return erreurs;
	}

}
