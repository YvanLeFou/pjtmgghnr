package dao;

import java.util.ArrayList;

import metier.Encherit;
import metier.Internaute;
import metier.Offre;

public interface DAOEncherit {

	public abstract void delete(Encherit e) throws Exception;

	public abstract Encherit get(Internaute pseudo, Offre idOffre) throws Exception;

	public abstract ArrayList<Encherit> loadAll() throws Exception;

	public abstract void save(Encherit e) throws Exception;

	public abstract void update(Encherit e) throws Exception;

}
