package metier;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Internaute implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nom = "";
    private String prenom = "";
    private String pseudo = "";
    private String mdp = "";
    private int numeroRue = 0;
    private String nomRue = "";
    private String ville = "";
    private String cp = "";
    private String telephone = "";
    private String email = "";
    private Droit droit = null;
    private Departement departement = null;
    private Set<Encherit> encherit = new HashSet<Encherit>();
    private Set<Offre> offre = new HashSet<Offre>();

    public Internaute(){
    }

	public Internaute(String nom, String prenom, String pseudo, String mdp,
			int numeroRue, String nomRue, String ville, String cp,
			String telephone, String email, Droit droit,
			Departement departement) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.pseudo = pseudo;
		this.mdp = mdp;
		this.numeroRue = numeroRue;
		this.nomRue = nomRue;
		this.ville = ville;
		this.cp = cp;
		this.telephone = telephone;
		this.email = email;
		this.droit = droit;
		this.departement = departement;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public int getNumeroRue() {
		return numeroRue;
	}

	public void setNumeroRue(int numeroRue) {
		this.numeroRue = numeroRue;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Droit getDroit() {
		return droit;
	}

	public void setDroit(Droit droit) {
		this.droit = droit;
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
	 * @return the offre
	 */
	public Set<Offre> getOffre() {
		return offre;
	}

	/**
	 * @param offre the offre to set
	 */
	public void setOffre(Set<Offre> offre) {
		this.offre = offre;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Internaute [nom=" + nom + ", prenom=" + prenom + ", pseudo="
				+ pseudo + ", mdp=" + mdp + ", numeroRue=" + numeroRue
				+ ", nomRue=" + nomRue + ", ville=" + ville + ", cp=" + cp
				+ ", telephone=" + telephone + ", email=" + email
				+ ", departement=" + departement + "] nbOffre : " + getOffre().size()
				+ ", nbEnchere : " + getEncherit().size();
	}
}
