package action.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Administrateur;
import metier.Categorie;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import daoHibernate.DAOCategorieHibernate;
import daoHibernate.DAOMotClefHibernate;
import daoHibernate.DAOOffreHibernate;

public class AdminSuppressionCategorie extends Action {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.
	 * ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Administrateur a = new Administrateur(new DAOOffreHibernate(),
				new DAOCategorieHibernate(), new DAOMotClefHibernate());

		int idCategorie = Integer.parseInt(request.getParameter("id"));

		Categorie c = a.getCategorie().get(idCategorie);

		if (a.nbOffresPourCategorie(idCategorie) == 0)
			a.getCategorie().delete(c);			
		else {
			ActionMessages erreur = new ActionMessages();
			erreur.add("adminGestionCategorie.suppressionImpossible", new ActionMessage(
					"adminGestionCategorie.suppressionImpossible"));
			this.addErrors(request, erreur);
		}

		return mapping.getInputForward();
	}

}
