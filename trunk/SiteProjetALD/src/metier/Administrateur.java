package metier;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

import org.apache.tomcat.jni.Time;

import daoHibernate.DAOOffreHibernate;

public class Administrateur {

	private Set<Offre> offre = new HashSet<Offre>();
	private Set<Categorie> categorie = new HashSet<Categorie>();
	private Set<MotClef> motclef = new HashSet<MotClef>();

	@SuppressWarnings("unchecked")
	public double getCA() throws Exception {
		
		DAOOffreHibernate dao = new DAOOffreHibernate();
		offre = (Set<Offre>) dao.loadAll();
				
		Date aujourdhui = new Date(Time.now());
		double ca = 0.0;
				
		//Recherche des offres aux dates inférieur à aujourd'hui
		for (Offre o : offre)
		        if(o.getDateFin().before(aujourdhui))
		        	//Recherche de l'enchère maximum
		        	ca += o.getMiseAPrix();		
		return ca;
	}

	@SuppressWarnings("unchecked")
	public double getCAMois(int mois, int annee) throws Exception {
		DAOOffreHibernate dao = new DAOOffreHibernate();
		offre = (Set<Offre>) dao.loadAll();
		
		@SuppressWarnings("deprecation")
		Date dateDebutMois = new Date(mois, annee, 1);
		//On prépare les dates entre lesquelles on veut calculer la CA
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(dateDebutMois);
		@SuppressWarnings("deprecation")
		Date dateFinMois = new Date(mois, annee, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		double ca = 0.0;
		
		//Recherche des offres entre les date de début et de fin de mois
		for (Offre o : offre){
		        if(o.getDateFin().after(dateDebutMois) && o.getDateFin().before(dateFinMois)){
		        	//Recherche de l'enchère maximum
		        	ca += o.getMiseAPrix();
		        }
		}
		
		return ca;
	}

	@SuppressWarnings("unchecked")
	public int getNbAnonceMois(int mois, int annee) throws Exception {
		
		DAOOffreHibernate dao = new DAOOffreHibernate();
		offre = (Set<Offre>) dao.loadAll();
		
		//On prépare les dates entre lesquelles on veut calculer la CA
		@SuppressWarnings("deprecation")
		Date dateDebutMois = new Date(mois, annee, 1);
		GregorianCalendar calendar = new GregorianCalendar();
		calendar.setTime(dateDebutMois);
		@SuppressWarnings("deprecation")
		Date dateFinMois = new Date(mois, annee, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		
		int nbAnnonce = 0;
				
		//Recherche des offres aux dates inférieur à aujourd'hui
		for (Offre o : offre)
			 if(o.getDateDepot().after(dateDebutMois) && o.getDateDepot().before(dateFinMois))
		        	nbAnnonce += 1;
		
		return nbAnnonce;
	}

	@SuppressWarnings("unchecked")
	public int getNbAnonceAnnee(int annee) throws Exception {
		DAOOffreHibernate dao = new DAOOffreHibernate();
		offre = (Set<Offre>) dao.loadAll();
		
		//On prépare les dates entre lesquelles on veut calculer la CA
		@SuppressWarnings("deprecation")
		Date dateDebutAnnee = new Date(1, annee, 1);
		@SuppressWarnings("deprecation")
		Date dateFinAnnee = new Date(12,annee,31);
		
		int nbAnnonce = 0;
				
		//Recherche des offres aux dates inférieur à aujourd'hui
		for (Offre o : offre)
			 if(o.getDateDepot().after(dateDebutAnnee) && o.getDateDepot().before(dateFinAnnee))
		        	nbAnnonce += 1;
		
		return nbAnnonce;
	}

	public Set<Offre> getOffre() {
		return offre;
	}

	public void setOffre(Set<Offre> offre) {
		this.offre = offre;
	}

	public Set<Categorie> getCategorie() {
		return categorie;
	}

	public void setCategorie(Set<Categorie> categorie) {
		this.categorie = categorie;
	}

	public Set<MotClef> getMotClef() {
		return motclef;
	}

	public void setMotClef(Set<MotClef> motclef) {
		this.motclef = motclef;
	}

}
