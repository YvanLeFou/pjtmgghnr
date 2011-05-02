package action.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Administrateur;
import metier.MotClef;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import action.form.ActionFormAdminFormuAjouterMotClef;
import daoHibernate.DAOCategorieHibernate;
import daoHibernate.DAOMotClefHibernate;
import daoHibernate.DAOOffreHibernate;

public class AdminAjouterMotClef extends Action 
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionFormAdminFormuAjouterMotClef formulaire = (ActionFormAdminFormuAjouterMotClef) form;
		
		Administrateur admin = new Administrateur(new DAOOffreHibernate(),new DAOCategorieHibernate(),new DAOMotClefHibernate());
		MotClef mc = new MotClef(formulaire.getLibelleMotClef());
		admin.getMotclef().save(mc);
		
		ActionFormAdminFormuAjouterMotClef forma = new ActionFormAdminFormuAjouterMotClef();
		request.setAttribute("adminAjouterCategorie", forma);
		return mapping.getInputForward();
	}

}
