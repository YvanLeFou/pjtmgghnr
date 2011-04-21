package action.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ActionFormFormuInscription extends ActionFormFormuCompte {
	private static final long serialVersionUID = 5920987576396511807L;
	
	private String mdp = "", mdp2 = "";
	
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

		ActionErrors errors = super.validate(mapping, request);
		
		if (getMdp().trim().isEmpty())
			errors.add("inscription.mdp.vide", new ActionMessage("inscription.mdp.vide"));
		
		if (getMdp2().trim().isEmpty())
			errors.add("inscription.mdp2.vide", new ActionMessage("inscription.mdp2.vide"));
		
		if (!getMdp().trim().equals(getMdp2().trim()))
			errors.add("inscription.mdp.identique", new ActionMessage("inscription.mdp.identique"));
		// il faut aussi vérifier que le pseudo n'est pas utilisé

		return errors;
	}
}
