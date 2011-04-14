package action.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ActionFormFormuIdentiteInternaute extends ActionForm {
	private static final long serialVersionUID = 5920987576396511807L;
	
	private String idOffre;
	
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
		return null;
	}
}
