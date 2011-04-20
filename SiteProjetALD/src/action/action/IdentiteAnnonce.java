package action.action;

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

public class IdentiteAnnonce extends Action {

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		System.out.println(request.getRequestURI());
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
		
		Offre o = new Offre("machin", "bidule", 3, 0, new Date(), new Date(), new Date(), 10, new Categorie("bidule"), new Departement("Machin"), 0, i);
		o.setImage(img);
		HashSet<Encherit> e = new HashSet<Encherit>();
		e.add(new Encherit(3., i, o));
		
		o.setEncherit(e);
		i.setEncherit(e);
		
		request.setAttribute("annonce", o);
		request.setAttribute("internaute", i);
		return mapping.findForward("identiteAnnonce");
	}

}
