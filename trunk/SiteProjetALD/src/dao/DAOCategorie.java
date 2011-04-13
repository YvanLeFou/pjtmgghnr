package dao;

import java.util.ArrayList;

import metier.Categorie;

public interface DAOCategorie {

	public abstract void delete(Categorie categorie) throws Exception;

	public abstract Categorie get(int IdCategorie) throws Exception;

	public abstract ArrayList<Categorie> loadAll() throws Exception;

	public abstract void save(Categorie categorie) throws Exception;

	public abstract void update(Categorie categorie) throws Exception;

}