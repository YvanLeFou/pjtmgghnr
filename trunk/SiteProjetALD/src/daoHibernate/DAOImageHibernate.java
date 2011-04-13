package daoHibernate;

import java.util.ArrayList;

import org.hibernate.Session;

import dao.DAOImage;


import metier.Image;

public class DAOImageHibernate extends DAOHibernate implements DAOImage{
	
	/* (non-Javadoc)
	 * @see daoHibernate.IDAOImage#delete(metier.Image)
	 */
	@Override
	public void delete(Image i) throws Exception {
		Session	session = connect();
		
		session.delete(i);
		i.setIdImage(-1);
		
		close(session);
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAOImage#get(int)
	 */
	@Override
	public Image get(int IdImage) throws Exception {
		Image i = null;
		Session	session = connect();
		
		i = (Image) session.get(Image.class, IdImage);
		
		close(session);
		return i;
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAOImage#loadAll()
	 */
	@Override
	@SuppressWarnings("unchecked")
	public ArrayList<Image> loadAll() throws Exception {
		ArrayList<Image>	tab = null;
		Session session = connect();
		
		tab = (ArrayList<Image>) session.createQuery("FROM Image")
				.list();
		
		close(session);
		return tab;
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAOImage#save(metier.Image)
	 */
	@Override
	public void save(Image i) throws Exception {
		Session	session = connect();
		
		session.save(i);
		
		close(session);		
	}

	/* (non-Javadoc)
	 * @see daoHibernate.IDAOImage#update(metier.Image)
	 */
	@Override
	public void update(Image i) throws Exception {
		Session	session = connect();
		
		session.update(i);
		
		close(session);
	}

}
