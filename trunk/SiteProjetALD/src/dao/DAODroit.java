package dao;

import java.util.ArrayList;

import metier.Droit;

public interface DAODroit {

	public abstract void delete(Droit d) throws Exception;

	public abstract Droit get(int IdDroit) throws Exception;

	public abstract ArrayList<Droit> loadAll() throws Exception;

	public abstract void save(Droit d) throws Exception;

	public abstract void update(Droit d) throws Exception;

}