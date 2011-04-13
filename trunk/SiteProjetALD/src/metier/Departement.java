package metier;

import java.io.Serializable;

public class Departement implements Serializable, Comparable<Departement> {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idDepartement = -1;
    private String libelleDepartement = null;
    private String code = null;
    private Region region = null;

    public Departement(){
    }
    
    public Departement(String libelle){
    	super();
    	this.libelleDepartement = libelle;
    }
    
    public Departement(int id, String libelle, Region r){
    	this.idDepartement = id;
    	this.libelleDepartement = libelle;
    	this.region = r;
    	this.region.getListeDepartements().add(this);
    }

	public int getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(int idDepartement) {
		this.idDepartement = idDepartement;
	}

	public String getLibelleDepartement() {
		return libelleDepartement;
	}

	public void setLibelleDepartement(String libelleDepartement) {
		this.libelleDepartement = libelleDepartement;
	}

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public int compareTo(Departement o) {
		return Double.compare(this.idDepartement, o.idDepartement);
	}

}
