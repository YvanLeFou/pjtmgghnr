package metier;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import dao.DAOCategorie;
import dao.DAOMotClef;
import dao.DAOOffre;

public class Administrateur {
	
	private DAOOffre offre;
	private DAOCategorie categorie;
	private DAOMotClef motclef;

	public Administrateur(DAOOffre daoOffre, DAOCategorie daoCategorie, DAOMotClef daoMotClef){
		offre = daoOffre;
		categorie = daoCategorie;
		motclef = daoMotClef;
	}
	
	public DAOOffre getOffre() {
		return offre;
	}

	public void setOffre(DAOOffre offre) {
		this.offre = offre;
	}

	public DAOCategorie getCategorie() {
		return categorie;
	}

	public void setCategorie(DAOCategorie categorie) {
		this.categorie = categorie;
	}

	public DAOMotClef getMotclef() {
		return motclef;
	}

	public void setMotclef(DAOMotClef motclef) {
		this.motclef = motclef;
	}
	
	public double getCAMois(int mois, int annee) throws Exception {
		
		ArrayList<Offre> offres = offre.loadAll();
				
		Calendar calendar = Calendar.getInstance();
		calendar.set(annee, mois, 1);
		Date dateDebutMois = calendar.getTime();
		calendar.set(annee, mois, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date dateFinMois = calendar.getTime();
		
		double ca = 0.0;
		
		//Recherche des offres entre les date de début et de fin de mois
		for (Offre o : offres){
		        if(o.getDateFin().after(dateDebutMois) && o.getDateFin().before(dateFinMois)){
		        	//Recherche de l'enchère maximum
		        	ca += o.getMiseAPrix();
		        }
		}
		
		return ca;
	}
	
	public Map<String, Double> getCADerniersMois() throws Exception {
		Map<String, Double>  resultat = new LinkedHashMap<String, Double>();
		Calendar calendar = Calendar.getInstance();
		String mois;
		Double caMois;
		
		for(int i = 0; i < 12 ; i++){
			calendar.add(Calendar.MONTH, -1);
			DateFormat dateFormat = new SimpleDateFormat("MMM yyyy");
			mois = dateFormat.format(calendar.getTime());
			caMois = this.getCAMois(calendar.get(Calendar.MONTH), calendar.get(Calendar.YEAR));
			resultat.put(mois,caMois);
		}
		
		return resultat;
	}
 
	public int getNbAnonceMois(int mois, int annee) throws Exception {
		
		ArrayList<Offre> offres = offre.loadAll();
		
		//On prépare les dates entre lesquelles on veut calculer la CA
		Calendar calendar = Calendar.getInstance();
		calendar.set(annee, mois, 1);
		Date dateDebutMois = calendar.getTime();
		calendar.set(annee, mois, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
		Date dateFinMois = calendar.getTime();
		
		int nbAnnonce = 0;
				
		//Recherche des offres aux dates inférieur à aujourd'hui
		for (Offre o : offres)
			 if(o.getDateDepot().after(dateDebutMois) && o.getDateDepot().before(dateFinMois))
		        	nbAnnonce += 1;
		
		return nbAnnonce;
	}

	public int getNbAnonceAnnee(int annee) throws Exception {
		
		ArrayList<Offre> offres = offre.loadAll();
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(annee, 0, 1);
		Date dateDebutAnnee = calendar.getTime();
		calendar.set(annee, 11, 31);
		Date dateFinAnnee = calendar.getTime();
		
		int nbAnnonce = 0;
				
		//Recherche des offres aux dates inférieur à aujourd'hui
		for (Offre o : offres)
			 if(o.getDateDepot().after(dateDebutAnnee) && o.getDateDepot().before(dateFinAnnee))
		        	nbAnnonce += 1;
		
		return nbAnnonce;
	}

}
