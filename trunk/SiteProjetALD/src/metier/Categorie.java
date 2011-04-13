package metier;

import java.io.Serializable;

public class Categorie implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idCategorie = -1;
    private String libelle = null;

    public Categorie(){
    }
    
	public Categorie(String libelle) {
		super();
		this.libelle = libelle;
	}


	public Categorie(int id, String libelle) {
		super();
		this.idCategorie = id;
		this.libelle = libelle;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

}
