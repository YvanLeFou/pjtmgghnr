package dao;

import java.util.ArrayList;

import metier.Categorie;
import metier.MotClef;

public interface DAOAdministrateur {

	public double getCA();

	public double getCAMois();

	public int getNbAnonceMois();

	public int getNbAnonceAnnee();

	public void addMotCle(String name);

	public void removeMotCle(int pos);

	public ArrayList<MotClef> getMotCle();

	public void setMotCle(int pos, String newName);

	public void addCategorie(String name);

	public void removeCategorie(int pos);

	public ArrayList<Categorie> getCategorie();

	public void setCategorie(int pos, String newName);

}
