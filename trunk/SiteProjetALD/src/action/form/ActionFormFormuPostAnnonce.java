package action.form;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class ActionFormFormuPostAnnonce extends ActionForm {
	private static final long serialVersionUID = 5920987576396511807L;
	
	private FormFile fileList = null;
	private String titre = "";
	private String description = "";
	private String dateFin = "";
	private double miseAPrix = 0;
	private boolean joignable = false;

	/**
	 * @return the fileList
	 */
	public FormFile getFileList() {
		return fileList;
	}

	/**
	 * @param fileList the fileList to set
	 */
	public void setFileList(FormFile fileList) {
		this.fileList = fileList;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the descrition
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param descrition the descrition to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the dateFin
	 */
	public String getDateFin() {
		return dateFin;
	}

	/**
	 * @param dateFin the dateFin to set
	 */
	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	/**
	 * @return the miseAPrix
	 */
	public double getMiseAPrix() {
		return miseAPrix;
	}

	/**
	 * @param miseAPrix the miseAPrix to set
	 */
	public void setMiseAPrix(double miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	/**
	 * @return the joignable
	 */
	public boolean isJoignable() {
		return joignable;
	}

	/**
	 * @param joignable the joignable to set
	 */
	public void setJoignable(boolean joignable) {
		this.joignable = joignable;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.struts.action.ActionForm#validate(org.apache.struts.action
	 * .ActionMapping, javax.servlet.http.HttpServletRequest)
	 */
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors erreurs = null;
		
		if (getTitre().trim().isEmpty() 
				|| getDateFin().trim().isEmpty()
				|| getDescription().trim().isEmpty()
				|| getFileList().getFileName().trim().isEmpty() 
				|| getMiseAPrix() <= 0)
		{
			erreurs = new ActionErrors();
			SimpleDateFormat sf = new SimpleDateFormat("d/M/y");
			
			if (getTitre().isEmpty())
				erreurs.add("postAnnonce.titre.vide", new ActionMessage("postAnnonce.titre.vide"));
			if (getDateFin().isEmpty())
				erreurs.add("postAnnonce.date.vide", new ActionMessage("postAnnonce.date.vide"));
			try
			{
				Date d = sf.parse(getDateFin());
				System.out.println("gŽnŽrŽ : " + d);
			}
			catch (ParseException e) 
			{
				erreurs.add("postAnnonce.date.invalideFormat", new ActionMessage("postAnnonce.date.invalideFormat"));
				System.out.println("erreurs date");
			}
			if (getDescription().isEmpty())
				erreurs.add("postAnnonce.description.vide", new ActionMessage("postAnnonce.description.vide"));
			if (getFileList().getFileName().trim().isEmpty() )
				erreurs.add("postAnnonce.img.vide", new ActionMessage("postAnnonce.img.vide"));
			if (getMiseAPrix() <= 0)
				erreurs.add("postAnnonce.map.vide", new ActionMessage("postAnnonce.map.vide"));
		}
		
		return erreurs;
	}
}
