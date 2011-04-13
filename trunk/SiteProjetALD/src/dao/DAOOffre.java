package dao;

import java.util.ArrayList;

import metier.Offre;

public interface DAOOffre {

	public abstract void delete(Offre o) throws Exception;

	public abstract Offre get(int IdOffre) throws Exception;

	public abstract ArrayList<Offre> loadAll() throws Exception;

	public abstract void save(Offre o) throws Exception;

	public abstract void update(Offre o) throws Exception;

}