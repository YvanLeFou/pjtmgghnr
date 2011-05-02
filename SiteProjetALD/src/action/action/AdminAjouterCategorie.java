package action.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Administrateur;
import metier.Categorie;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import action.form.ActionFormAdminFormuAjouterCategorie;
import daoHibernate.DAOCategorieHibernate;
import daoHibernate.DAOMotClefHibernate;
import daoHibernate.DAOOffreHibernate;

public class AdminAjouterCategorie extends Action 
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionFormAdminFormuAjouterCategorie formulaire = (ActionFormAdminFormuAjouterCategorie) form;
		
		Administrateur admin = new Administrateur(new DAOOffreHibernate(),new DAOCategorieHibernate(),new DAOMotClefHibernate());
		Categorie c = new Categorie(formulaire.getLibelleCategorie());
		admin.getCategorie().save(c);
		
		ActionFormAdminFormuAjouterCategorie forma = new ActionFormAdminFormuAjouterCategorie();
		request.setAttribute("adminAjouterCategorie", forma);
		
		return mapping.getInputForward();
	}

}
