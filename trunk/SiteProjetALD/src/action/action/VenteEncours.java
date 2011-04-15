package action.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Categorie;
import metier.Departement;
import metier.Encherit;
import metier.Image;
import metier.Internaute;
import metier.Offre;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class VenteEncours extends Action {

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
ArrayList<Offre> offre = new ArrayList<Offre>();
		
		Internaute i = (Internaute) request.getSession().getAttribute("pseudo");
		
		TreeSet<Image> img = new TreeSet<Image>();
		img.add(new Image("ImageUpload/mpd.png"));
		img.add(new Image("ImageUpload/mpd.png"));
		img.add(new Image("ImageUpload/mpd.png"));
		
		Offre o = new Offre("machin", "bidule", 3, 0, new Date(), new Date(), new Date(), 10, new Categorie("bidule"), new Departement("Machin"), new HashSet<Encherit>(), img, 0, i);
		
		HashSet<Encherit> e = new HashSet<Encherit>();
		e.add(new Encherit(3., i, o));
		
		o.setEncherit(e);
		
		
		offre.add(o);
		
		request.setAttribute("listRecherche", offre);
		return mapping.findForward("resultatRecherche");
	}

}
