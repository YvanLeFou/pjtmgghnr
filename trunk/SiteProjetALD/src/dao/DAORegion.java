package dao;

import java.util.ArrayList;

import metier.Region;

public interface DAORegion {

	public void delete(Region r) throws Exception;

	public Region get(int IdRegion) throws Exception;

	public ArrayList<Region> loadAll() throws Exception;

	public void save(Region r) throws Exception;

	public void update(Region r) throws Exception;
}