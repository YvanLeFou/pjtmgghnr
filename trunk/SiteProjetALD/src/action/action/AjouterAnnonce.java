package action.action;

import java.io.File;
import java.io.FileOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

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
		System.out.println(f.getFileList().getFileName());
		FormFile myFile = f.getFileList();

		String contentType = myFile.getContentType();
		
		// recuperer le nom du fichier
		String fileName = myFile.getFileName();
		int fileSize = myFile.getFileSize();
		byte[] fileData = myFile.getFileData();
		// ca permet de retourne le chemin où sera sauvegarder le fichier
		String filePath = getServlet().getServletContext().getRealPath("/") + "ImageUpload";
		/* Sauvegarde du fichier dans le serveur */
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

		return mapping.findForward("retour");
	}
}
