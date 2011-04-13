package dao;

import java.util.ArrayList;

import metier.Internaute;

public interface DAOInternaute {

	public abstract void delete(Internaute i) throws Exception;

	public abstract Internaute get(String pseudo) throws Exception;

	public abstract ArrayList<Internaute> loadAll() throws Exception;

	public abstract void save(Internaute i) throws Exception;

	public abstract void update(Internaute i) throws Exception;

}