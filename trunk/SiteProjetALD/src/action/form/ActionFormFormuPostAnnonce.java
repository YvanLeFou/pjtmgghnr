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
	private String dateFin = "", dateDeb = "";
	private double miseAPrix = 0;
	private boolean joignable = false;
	
	private int categorie, departement;

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
	 * @return the dateDeb
	 */
	public String getDateDeb() {
		return dateDeb;
	}

	/**
	 * @param dateDeb the dateDeb to set
	 */
	public void setDateDeb(String dateDeb) {
		this.dateDeb = dateDeb;
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

	/**
	 * @return the categorie
	 */
	public int getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie the categorie to set
	 */
	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}

	/**
	 * @return the departement
	 */
	public int getDepartement() {
		return departement;
	}

	/**
	 * @param departement the departement to set
	 */
	public void setDepartement(int departement) {
		this.departement = departement;
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
		ActionErrors erreurs = new ActionErrors();
		SimpleDateFormat sf = new SimpleDateFormat("d/M/y");
		
		if (getTitre().trim().isEmpty())
			erreurs.add("postAnnonce.titre.vide", new ActionMessage("postAnnonce.titre.vide"));
		if (getDateFin().trim().isEmpty())
			erreurs.add("postAnnonce.datefin.vide", new ActionMessage("postAnnonce.datefin.vide"));
		try
		{
			Date d = sf.parse(getDateFin());
			Date ref = new Date();

			System.out.println("ref ? d <=>" + ref + " ? " + d);
			if (d.compareTo(ref) < 0)
			{
				System.out.println("normalement d est antŽrieur ˆ ref");
				erreurs.add("postAnnonce.datefin.pbenchere", new ActionMessage("postAnnonce.datefin.pbenchere"));
			}
			
			System.out.println("gŽnŽrŽ : " + d);
		}
		catch (ParseException e) 
		{
			erreurs.add("postAnnonce.datefin.invalideFormat", new ActionMessage("postAnnonce.datefin.invalideFormat"));
			System.out.println("erreurs date");
		}
		
		if (!getDateDeb().trim().isEmpty())
		{
			try
			{
				Date d = sf.parse(getDateDeb());
				System.out.println("gŽnŽrŽ : " + d);
			}
			catch (ParseException e) 
			{
				erreurs.add("postAnnonce.datedeb.invalideFormat", new ActionMessage("postAnnonce.datedeb.invalideFormat"));
				System.out.println("erreurs date");
			}
		}
		
		if (getDescription().trim().isEmpty())
			erreurs.add("postAnnonce.description.vide", new ActionMessage("postAnnonce.description.vide"));
		if (getFileList().getFileName().trim().isEmpty() )
			erreurs.add("postAnnonce.img.vide", new ActionMessage("postAnnonce.img.vide"));
		if (getMiseAPrix() <= 0)
			erreurs.add("postAnnonce.map.vide", new ActionMessage("postAnnonce.map.vide"));
		
		return erreurs;
	}
}
