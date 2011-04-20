package metier;

import java.io.Serializable;

public class Image implements Serializable, Comparable<Image>{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idImage = -1;
    private String libelleImage = null;
    private Offre idOffre = null;
    
	public Image(){
	}
	
	public Image(String libelle) {
		super();
		this.libelleImage = libelle;
	}


	public Image(int id, String libelle, Offre idOffre) {
		super();
		this.idImage = id;
		this.libelleImage= libelle;
		this.idOffre = idOffre;
	}

    public Offre getIdOffre() {
		return idOffre;
	}

	public void setIdOffre(Offre idOffre) {
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

	@Override
	public int compareTo(Image a) {
		return Double.compare(idImage, a.idImage);
	}

	@Override
	public String toString() {
		return "Image [idImage=" + idImage + ", libelleImage=" + libelleImage
				+ "]";
	}

}
