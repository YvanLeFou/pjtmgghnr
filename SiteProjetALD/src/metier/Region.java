package metier;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Region implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idRegion = -1;
    private String libelle = null;
    private Set<Departement> listeDepartements = new HashSet<Departement>();

    public Region(){
    }
    
    public Region(String libelle){
    	super();
    	this.libelle = libelle;
    }
    
    public Region(int id, String libelle, Set<Departement> listeDepartements ){
    	this.idRegion = id;
    	this.libelle = libelle;
    	this.listeDepartements = listeDepartements;
    }

    
	public Set<Departement> getListeDepartements() {
		return listeDepartements;
	}

	public void setListeDepartements(Set<Departement> listeDepartements) {
		this.listeDepartements = listeDepartements;
	}

	public int getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	public String toString()
	{
		return this.libelle;
	}

}
