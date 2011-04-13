package metier;

import java.io.Serializable;

public class Image implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idImage = -1;
    private String libelleImage = null;
    private int idOffre = -1;
    
	public Image(){
	}
	
	public Image(String libelle) {
		super();
		this.libelleImage = libelle;
	}


	public Image(int id, String libelle, int idOffre) {
		super();
		this.idImage = id;
		this.libelleImage= libelle;
		this.idOffre = idOffre;
	}

    public int getIdOffre() {
		return idOffre;
	}

	public void setIdOffre(int idOffre) {
		this.idOffre = idOffre;
	}

	public int getIdImage() {
		return idImage;
	}

	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}

	public String getLibelleImage() {
		return libelleImage;
	}

	public void setLibelleImage(String libelleImage) {
		this.libelleImage = libelleImage;
	}

}
