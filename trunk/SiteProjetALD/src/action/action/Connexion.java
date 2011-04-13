package action.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Departement;
import metier.Internaute;
import metier.Region;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import action.form.ActionFormFormuRapide;

public class Connexion extends Action 
{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionFormFormuRapide fm = (ActionFormFormuRapide) form;
		//si la personne existe dans la base de données
		
		//if () //si resultat dans la base 
		{
			Internaute i = new Internaute();
			i.setNom("reitz");
			i.setPrenom("nicolas");
			i.setPseudo(fm.getPseudo());
			i.setCp("57700");
			Region r = new Region("Lorraine");
			Departement p = new Departement(55, "Moselle", r);
			r.setIdRegion(13);
			r.getListeDepartements().add(p);
			i.setDepartement(p);
			i.setEmail("nicolas.reitz@gmx.fr");
			i.setMdp("truc");
			i.setNomRue("rue des pommiers");
			i.setNumeroRue(28);
			i.setTelephone("haha");
			i.setVille("Hayange");
			request.getSession().setAttribute("pseudo", i);
		}
		//else // pas de resultat
		{
			
		}
		
		return mapping.findForward("index");
	}

}
