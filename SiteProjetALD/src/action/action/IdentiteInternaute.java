package action.action;

import java.util.Calendar;
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
import metier.Region;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import action.form.ActionFormFormuIdentiteInternaute;

public class IdentiteInternaute extends Action {

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionFormFormuIdentiteInternaute f = (ActionFormFormuIdentiteInternaute)form;
		System.out.println(f.getIdOffre());
		
		Internaute i = new Internaute();
		i.setNom("Bop");
		i.setPrenom("Billy");
		i.setPseudo("Pipo");
		i.setCp("56500");
		Region r = new Region("Ardennes");
		Departement p = new Departement(55, "Belges", r);
		r.setIdRegion(13);
		r.getListeDepartements().add(p);
		i.setDepartement(p);
		i.setEmail("piloupollu@wanadoo.fr");
		i.setMdp("truc");
		i.setNomRue("rue des peuplier");
		i.setNumeroRue(28);
		i.setTelephone("03-45-21-23-54");
		i.setVille("Ursule");
		
		TreeSet<Image> img = new TreeSet<Image>();
		img.add(new Image("ImageUpload/mpd.png"));
		img.add(new Image("ImageUpload/mpd.png"));
		img.add(new Image("ImageUpload/mpd.png"));
		
		Offre o = new Offre("machin", "bidule", 3, 0, new Date(), new Date(), new Date(), 10, new Categorie("bidule"), new Departement("Machin"), new HashSet<Encherit>(), img, 0, i);
		
		HashSet<Encherit> e = new HashSet<Encherit>();
		e.add(new Encherit(3., i, o));
		o.setEncherit(e);
		i.setEncherit(e);
		
		Calendar c = Calendar.getInstance();
		c.set(2011, 10, 21, 21, 24, 32);
		Offre oo = new Offre("truc", "bidule", 3, 0, c.getTime(), c.getTime(), c.getTime(), 10, new Categorie("bidule"), new Departement("Machin"), new HashSet<Encherit>(), img, 0, i);
		Offre ooo = new Offre("bidule", "bidule", 3, 0, new Date(), new Date(), new Date(), 11, new Categorie("bidule"), new Departement("Machin"), new HashSet<Encherit>(), img, 0, i);
		oo.setInternaute(i);
		ooo.setInternaute(i);
		
		HashSet<Offre> objVente = new HashSet<Offre>();
		objVente.add(ooo);
		objVente.add(oo);
		i.setOffre(objVente);
		
		request.setAttribute("annonce", i.getOffre());
		request.setAttribute("internaute", i);
		request.setAttribute("nbVente", i.getOffre().size());
		request.setAttribute("nbAchat", i.getOffre().size());
		
		return mapping.findForward("identiteInternaute");
	}

}
