package dao;

import java.util.ArrayList;

import metier.Encherit;

public interface DAOEncherit {

	public abstract void delete(Encherit e) throws Exception;

	public abstract Encherit get(String pseudo, int idOffre) throws Exception;

	public abstract ArrayList<Encherit> loadAll() throws Exception;

	public abstract void save(Encherit e) throws Exception;

	public abstract void update(Encherit e) throws Exception;

}
