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

import daoHibernate.DAORegionHibernate;

public class AjaxAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String str = "";
		int idRegion = Integer.parseInt(request.getParameter("data"));
		
		DAORegionHibernate dao = new DAORegionHibernate();
		Region region = null;
		region = dao.get(idRegion);
		
		SortedSet<Departement> listDep = new TreeSet<Departement>(region.getListeDepartements());
		
		for(Departement d : listDep)
			str += "<option value='" + d.getIdDepartement() + "'>" + d.getLibelleDepartement() + "</option>\n";
		
		out.println(str);
		out.flush();
		return null;
	}
}