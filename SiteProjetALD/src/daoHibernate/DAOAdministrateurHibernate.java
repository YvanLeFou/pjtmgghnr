package daoHibernate;

import java.util.ArrayList;

import metier.Categorie;
import metier.MotClef;
import dao.DAOAdministrateur;

public class DAOAdministrateurHibernate implements DAOAdministrateur {

	@Override
	public double getCA() {
		return 0;
	}

	@Override
	public double getCAMois() {
		return 0;
	}

	@Override
	public int getNbAnonceMois() {
		return 0;
	}

	@Override
	public int getNbAnonceAnnee() {
		return 0;
	}

	@Override
	public void addMotClef(String name) {

	}

	@Override
	public void removeMotClef(int pos) {

	}

	@Override
	public ArrayList<MotClef> getMotClef() {
		return null;
	}

	@Override
	public void setMotClef(int pos, String newName) {

	}

	@Override
	public void addCategorie(String name) {

	}

	@Override
	public void removeCategorie(int pos) {

	}

	@Override
	public ArrayList<Categorie> getCategorie() {
		return null;
	}

	@Override
	public void setCategorie(int pos, String newName) {

	}

}
