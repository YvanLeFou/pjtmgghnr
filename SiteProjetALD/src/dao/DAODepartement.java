package dao;


import java.util.ArrayList;

import metier.Departement;

public interface DAODepartement {

	public abstract void delete(Departement d) throws Exception;

	public abstract Departement get(int IdDep) throws Exception;

	public abstract ArrayList<Departement> loadAll() throws Exception;

	public abstract void save(Departement d) throws Exception;

	public abstract void update(Departement d) throws Exception;

}