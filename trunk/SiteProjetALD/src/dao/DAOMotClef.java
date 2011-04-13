package dao;

import java.util.ArrayList;

import metier.MotClef;

public interface DAOMotClef {

	public abstract void delete(MotClef mc) throws Exception;

	public abstract MotClef get(int IdMotClef) throws Exception;

	public abstract ArrayList<MotClef> loadAll() throws Exception;

	public abstract void save(MotClef mc) throws Exception;

	public abstract void update(MotClef mc) throws Exception;

}