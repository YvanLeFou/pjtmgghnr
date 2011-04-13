package action.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class ActionFormFormuRecherche extends ActionForm {
	private static final long serialVersionUID = 4676113385825779305L;

	private String motclef = "";
	private String categorie = "";
	private String departementSelect = "";
	private String min = "", max = "";
	
	public ActionFormFormuRecherche() {
	}

	/**
	 * @return the motclef
	 */
	public String getMotclef() {
		return motclef;
	}

	/**
	 * @param motclef the motclef to set
	 */
	public void setMotclef(String motclef) {
		this.motclef = motclef;
	}

	/**
	 * @return the categorie
	 */
	public String getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the departementSelect
	 */
	public String getDepartementSelect() {
		return departementSelect;
	}

	/**
	 * @param departementSelect the departementSelect to set
	 */
	public void setDepartementSelect(String departementSelect) {
		this.departementSelect = departementSelect;
	}
	
	/**
	 * @return the min
	 */
	public String getMin() {
		return min;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(String min) {
		this.min = min;
	}

	/**
	 * @return the max
	 */
	public String getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(String max) {
		this.max = max;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.action.ActionForm#validate(org.apache.struts.action.ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors errors = null;
		
		if (!getMin().trim().isEmpty())
		{
			try 
			{
				Double.parseDouble(getMin().trim());
			}
			catch (NumberFormatException e) 
			{
				if (errors == null)
					errors = new ActionErrors();
				errors.add("recherche.min.invalide", new ActionMessage("recherche.min.invalide"));
			}
		}
		
		if (!getMax().trim().isEmpty())
		{
			try 
			{
				Double.parseDouble(getMax().trim());
			}
			catch (NumberFormatException e) 
			{
				if (errors == null)
					errors = new ActionErrors();
				errors.add("recherche.max.invalide", new ActionMessage("recherche.max.invalide"));
			}
		}
		
		return errors;
	}
}
