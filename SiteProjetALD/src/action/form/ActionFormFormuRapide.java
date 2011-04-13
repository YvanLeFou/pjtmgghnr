package action.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ActionFormFormuRapide extends ActionForm 
{
	private static final long serialVersionUID = 5920987576396511807L;

	private String pseudo = "";
	private String mdp = "";
	
	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}
	
	/**
	 * @param pseudo the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
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
	
	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = null;
		
		if (getPseudo().trim().isEmpty() || getMdp().trim().isEmpty())
		{
			errors = new ActionErrors();
			
			if (getPseudo().trim().isEmpty())
				errors.add("connexion.pseudo.vide", new ActionMessage("connexion.pseudo.vide"));
			
			if (getMdp().trim().isEmpty())
				errors.add("connexion.mdp.vide", new ActionMessage("connexion.mdp.vide"));
		}
		
		return errors;
	}
}
