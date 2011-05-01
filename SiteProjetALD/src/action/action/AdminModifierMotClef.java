package action.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Administrateur;
import metier.MotClef;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import action.form.ActionFormAdminFormuModifierMotClef;
import daoHibernate.DAOCategorieHibernate;
import daoHibernate.DAOMotClefHibernate;
import daoHibernate.DAOOffreHibernate;

public class AdminModifierMotClef extends Action 
{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionFormAdminFormuModifierMotClef formulaire = (ActionFormAdminFormuModifierMotClef) form;
		
		Administrateur admin = new Administrateur(new DAOOffreHibernate(),new DAOCategorieHibernate(),new DAOMotClefHibernate());
		
		MotClef mc = admin.getMotclef().get(Integer.parseInt(formulaire.getIdMotClef()));
		
		mc.setLibelleMotClef(formulaire.getLibelleMotClef());
		
		admin.getMotclef().update(mc);
		
		mc = admin.getMotclef().get(Integer.parseInt(formulaire.getIdMotClef()));
		
		return mapping.getInputForward();
	}

}
