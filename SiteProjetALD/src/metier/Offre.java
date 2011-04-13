package metier;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;

public class Offre  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String titre = null;
    private String description = null;
    private double miseAPrix = 0.0;
    private int joignable = 0;
    private Date dateDebut = null;
    private Date dateFin = null;
    private Date dateDepot = null;
    private int idOffre = -1;
    private Categorie categorie = null;
    private Departement departement = null;
    private HashSet<Encherit> encherit = null;
    private HashSet<Image> image = null;
    private int suspecte = 0;
    private Internaute internaute = null;

    public Offre(){
    }

	public Offre(String titre, String description, double miseAPrix,
			int joignable, Date dateDebut, Date dateFin, Date dateDepot,
			int idOffre, Categorie categorie, Departement departement,
			HashSet<Encherit> encherit, HashSet<Image> image, int suspecte,
			Internaute internaute) {
		super();
		this.titre = titre;
		this.description = description;
		this.miseAPrix = miseAPrix;
		this.joignable = joignable;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.dateDepot = dateDepot;
		this.idOffre = idOffre;
		this.categorie = categorie;
		this.departement = departement;
		this.encherit = encherit;
		this.image = image;
		this.suspecte = suspecte;
		this.internaute = internaute;
	}


	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public HashSet<Encherit> getEncherit() {
		return encherit;
	}

	public void setEncherit(HashSet<Encherit> encherit) {
		this.encherit = encherit;
	}

	public HashSet<Image> getImage() {
		return image;
	}

	public void setImage(HashSet<Image> image) {
		this.image = image;
	}

	public int isSuspecte() {
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

}
