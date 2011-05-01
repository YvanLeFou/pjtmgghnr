<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>

<h1><bean:message key="menuAdmin.titre"/></h1>
<ul>
	<li><html:link action="/adminChiffreAffaire.do"><bean:message key="menuAdmin.lien.chiffreAffaire"/></html:link></li>
	<li><html:link action="/adminNombreAnnonces.do"><bean:message key="menuAdmin.lien.nombreAnnonces"/></html:link></li>
	<li><html:link action="/adminGestionMotsClefs.do"><bean:message key="menuAdmin.lien.gestionMotsClefs"/></html:link></li>
	<li><html:link action="/adminAnnoncesDouteuses.do"><bean:message key="menuAdmin.lien.AnnoncesDouteuses"/></html:link></li>
	<li><html:link action="/adminGestionCategories.do"><bean:message key="menuAdmin.lien.gestionCategorie"/></html:link></li>
	
</ul>
