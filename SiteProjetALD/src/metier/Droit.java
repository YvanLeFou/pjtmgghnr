package metier;

import java.io.Serializable;

public class Droit implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idDroit = -1;
    private String libelleDroit = null;

    public Droit(){
    }
    
    public Droit(String libelle){
    	super();
    	this.libelleDroit = libelle;
    }
    
    public Droit(int id, String libelle){
    	this.idDroit = id;
    	this.libelleDroit = libelle;
    }

	public int getIdDroit() {
		return idDroit;
	}

	public void setIdDroit(int idDroit) {
		this.idDroit = idDroit;
	}

	public String getLibelleDroit() {
		return libelleDroit;
	}

	public void setLibelleDroit(String libelleDroit) {
		this.libelleDroit = libelleDroit;
	}

}
