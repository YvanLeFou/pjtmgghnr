package action.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Administrateur;
import metier.Categorie;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import action.form.ActionFormAdminFormuModifierCategorie;
import dao.DAOCategorie;
import daoHibernate.DAOCategorieHibernate;
import daoHibernate.DAOMotClefHibernate;
import daoHibernate.DAOOffreHibernate;

public class AdminModifierCategorie extends Action 
{
	private DAOCategorie daoCategorie;

	public DAOCategorie getDaoCategorie() {
		return daoCategorie;
	}

	public void setDaoCategorie(DAOCategorie daoCategorie) {
		this.daoCategorie = daoCategorie;
	}
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionFormAdminFormuModifierCategorie formulaire = (ActionFormAdminFormuModifierCategorie) form;
		
		Administrateur admin = new Administrateur();
		admin.setCategorie(daoCategorie);
		
		Categorie c = admin.getCategorie().get(Integer.parseInt(formulaire.getIdCategorie()));
		
		c.setLibelle(formulaire.getLibelleCategorie());
		
		admin.getCategorie().update(c);
		
		c = admin.getCategorie().get(Integer.parseInt(formulaire.getIdCategorie()));
		
		ActionFormAdminFormuModifierCategorie forma = new ActionFormAdminFormuModifierCategorie();
		request.setAttribute("adminModifierCategorie", forma);
		
		return mapping.getInputForward();
	}

}
