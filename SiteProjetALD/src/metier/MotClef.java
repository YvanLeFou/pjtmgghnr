package metier;

import java.io.Serializable;

public class MotClef  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idMotClef = -1;
    private String libelleMotClef = null;

    public MotClef(){
    }
    
	public MotClef(String libelle) {
		super();
		this.libelleMotClef = libelle;
	}


	public MotClef(int id, String libelle) {
		super();
		this.idMotClef = id;
		this.libelleMotClef = libelle;
	}

	public int getIdMotClef() {
		return idMotClef;
	}

	public void setIdMotClef(int idMotClef) {
		this.idMotClef = idMotClef;
	}

	public String getLibelleMotClef() {
		return libelleMotClef;
	}

	public void setLibelleMotClef(String libelleMotClef) {
		this.libelleMotClef = libelleMotClef;
	}

}
