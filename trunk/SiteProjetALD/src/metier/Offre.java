package metier;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Offre  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titre = "";
    private String descriptif = "";
    private double miseAPrix = 0.0;
    private int joignable = 0;
    private Date dateDebut = null;
    private Date dateFin = null;
    private Date dateDepot = null;
    private int idOffre = -1;
    private Categorie categorie = null;
    private Departement departement = null;
    private Set<Encherit> encherit = new HashSet<Encherit>();
    private Set<Image> image = new HashSet<Image>();
    private int suspecte = 0;
    private Internaute internaute = null;

    public Offre(){
    }

	public Offre(String titre, String description, double miseAPrix,
			int joignable, Date dateDebut, Date dateFin, Date dateDepot,
			int idOffre, Categorie categorie, Departement departement, int suspecte,
			Internaute internaute) {
		super();
		this.titre = titre;
		this.descriptif = description;
		this.miseAPrix = miseAPrix;
		this.joignable = joignable;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.dateDepot = dateDepot;
		this.idOffre = idOffre;
		this.categorie = categorie;
		this.departement = departement;
		this.suspecte = suspecte;
		this.internaute = internaute;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescriptif() {
		return descriptif;
	}

	public void setDescriptif(String descriptif) {
		this.descriptif = descriptif;
	}

	public double getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(double miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public int getJoignable() {
		return joignable;
	}

	public void setJoignable(int joignable) {
		this.joignable = joignable;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Date getDateDepot() {
		return dateDepot;
	}

	public void setDateDepot(Date dateDepot) {
		this.dateDepot = dateDepot;
	}

	public int getIdOffre() {
		return idOffre;
	}

	public void setIdOffre(int idOffre) {
		this.idOffre = idOffre;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public Set<Encherit> getEncherit() {
		return encherit;
	}

	public void setEncherit(Set<Encherit> encherit) {
		this.encherit = encherit;
	}

	/**
	 * @return the image
	 */
	public Set<Image> getImage() {
		return image;
	}

	/**
	 * @param image the image to set
	 */
	public void setImage(Set<Image> image) {
		this.image = image;
	}

	public int getSuspecte() {
		return suspecte;
	}

	public void setSuspecte(int suspecte) {
		this.suspecte = suspecte;
	}

	public Internaute getInternaute() {
		return internaute;
	}

	public void setInternaute(Internaute internaute) {
		this.internaute = internaute;
	}
	
	

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Offre [titre=" + titre + ", image=" + image + "]";
	}

}
