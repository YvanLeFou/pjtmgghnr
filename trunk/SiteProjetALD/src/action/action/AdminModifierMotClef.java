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
import dao.DAOMotClef;

public class AdminModifierMotClef extends Action {

	private DAOMotClef daoMotClef;

	public DAOMotClef getDaoMotClef() {
		return daoMotClef;
	}

	public void setDaoMotClef(DAOMotClef daoMotClef) {
		this.daoMotClef = daoMotClef;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionFormAdminFormuModifierMotClef formulaire = (ActionFormAdminFormuModifierMotClef) form;

		Administrateur admin = new Administrateur();
		admin.setMotclef(daoMotClef);

		MotClef mc = admin.getMotclef().get(
				Integer.parseInt(formulaire.getIdMotClef()));

		mc.setLibelleMotClef(formulaire.getLibelleMotClef());

		admin.getMotclef().update(mc);

		mc = admin.getMotclef()
				.get(Integer.parseInt(formulaire.getIdMotClef()));

		ActionFormAdminFormuModifierMotClef forma = new ActionFormAdminFormuModifierMotClef();
		request.setAttribute("adminModifierMotClef", forma);

		return mapping.getInputForward();
	}

}
