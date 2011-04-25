package dao;

import java.util.ArrayList;

import metier.Internaute;
import metier.Offre;

public interface DAOOffre {

	public abstract void delete(Offre o) throws Exception;

	public abstract Offre get(int IdOffre) throws Exception;

	public abstract ArrayList<Offre> loadAll() throws Exception;

	public abstract void save(Offre o) throws Exception;

	public abstract void update(Offre o) throws Exception;

	public abstract ArrayList<Offre> findThem(String motClef, int Categorie, int departement, double prixMin, double prixMax) throws Exception;

	public abstract ArrayList<Offre> getVenteEncours(Internaute i) throws Exception;
	
	public abstract ArrayList<Offre> getHistoriqueVente(Internaute i) throws Exception;

	public abstract ArrayList<Offre> getEnchereEncours(Internaute i) throws Exception;
	
	public abstract ArrayList<Offre> getHistoriqueAchat(Internaute i) throws Exception;
}