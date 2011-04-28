package dao;

import java.util.ArrayList;

import metier.Categorie;
import metier.MotClef;

public interface DAOAdministrateur {

	public double getCA();

	public double getCAMois();

	public int getNbAnonceMois();

	public int getNbAnonceAnnee();

	public void addMotClef(String name);

	public void removeMotClef(int pos);

	public ArrayList<MotClef> getMotClef();

	public void setMotClef(int pos, String newName);

	public void addCategorie(String name);

	public void removeCategorie(int pos);

	public ArrayList<Categorie> getCategorie();

	public void setCategorie(int pos, String newName);

}
