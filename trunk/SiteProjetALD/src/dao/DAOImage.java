package dao;

import java.util.ArrayList;

import metier.Image;

public interface DAOImage {

	public abstract void delete(Image i) throws Exception;

	public abstract Image get(int IdImage) throws Exception;

	public abstract ArrayList<Image> loadAll() throws Exception;

	public abstract void save(Image i) throws Exception;

	public abstract void update(Image i) throws Exception;

}