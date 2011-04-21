package action.action;

import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Image;
import metier.Internaute;
import metier.Offre;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import daoHibernate.DAOCategorieHibernate;
import daoHibernate.DAODepartementHibernate;
import daoHibernate.DAOOffreHibernate;

import action.form.ActionFormFormuPostAnnonce;

public class AjouterAnnonce extends Action {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.
	 * ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ActionFormFormuPostAnnonce f = (ActionFormFormuPostAnnonce) form;
		FormFile myFile = f.getFileList();

		//String contentType = myFile.getContentType();
		
		// recuperer le nom du fichier
		String fileName = "" + DateFormat.getInstance().format(new Date()).replace(File.separatorChar, '-');
		System.out.println(fileName);
		
		//int fileSize = myFile.getFileSize();
		//byte[] fileData = myFile.getFileData();
		// ca permet de retourne le chemin où sera sauvegarder le fichier
		String filePath = getServlet().getServletContext().getRealPath("/") + "ImageUpload";
		// Sauvegarde du fichier dans le serveur //
		if (!fileName.equals("")) {
			System.out.println("Serveur path:" + filePath);
			// creer le fichier
			File fileToCreate = new File(filePath, fileName);
			// si le fichier n'existe pas, il faut le sauvegarder
			if (!fileToCreate.exists()) {
				FileOutputStream fileOutStream = new FileOutputStream(
						fileToCreate);
				fileOutStream.write(myFile.getFileData());
				fileOutStream.flush();
				fileOutStream.close();
				System.out.println("fichier sauvegarder");
			}
			else
			{
				System.out.println("cond fausse");
			}
		}
		
		System.out.println(filePath+File.separator+fileName);
		DAODepartementHibernate daoDep = new DAODepartementHibernate();
		DAOCategorieHibernate daoCat = new DAOCategorieHibernate();
		
		SimpleDateFormat sd = new SimpleDateFormat("d/M/y");
		Date dateDeb = 	f.getDateDeb().trim().isEmpty() ? new Date() : sd.parse(f.getDateDeb()), 
						dateFin = sd.parse(f.getDateFin());
		
		Offre o = new Offre(f.getTitre(), f.getDescription(), f.getMiseAPrix(), f.isJoignable() ? 1 : 0, dateDeb, dateFin, new Date(), -1, daoCat.get(f.getCategorie()), daoDep.get(f.getDepartement()), 0, (Internaute)(request.getSession().getAttribute("pseudo"))); 
		o.getImage().add(new Image(-1, "ImageUpload"+File.separator+fileName, o));
		
		DAOOffreHibernate dao = new DAOOffreHibernate();
		
		dao.save(o);

		return mapping.findForward("retour");
	}
}
