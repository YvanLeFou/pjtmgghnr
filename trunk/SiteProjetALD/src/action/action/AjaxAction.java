package action.action;

import java.io.PrintWriter;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.Departement;
import metier.Region;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import dao.DAORegion;

public class AjaxAction extends Action {
	private DAORegion daoRegion;
	
	/**
	 * @return the daoRegion
	 */
	public DAORegion getDaoRegion() {
		return daoRegion;
	}

	/**
	 * @param daoRegion the daoRegion to set
	 */
	public void setDaoRegion(DAORegion daoRegion) {
		this.daoRegion = daoRegion;
	}

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String str = "";
		int idRegion = Integer.parseInt(request.getParameter("data"));
		
		Region region = null;
		region = daoRegion.get(idRegion);
		
		SortedSet<Departement> listDep = new TreeSet<Departement>(region.getListeDepartements());
		
		for(Departement d : listDep)
			str += "<option value='" + d.getIdDepartement() + "'>" + d.getLibelleDepartement() + "</option>\n";
		
		out.println(str);
		out.flush();
		return null;
	}
}