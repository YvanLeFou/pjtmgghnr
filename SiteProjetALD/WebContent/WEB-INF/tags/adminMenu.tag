<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>

<h1><bean:message key="menuAdmin.titre"/></h1>
<ul>
	<li><html:link action="/chiffreAffaire.do"><bean:message key="menuAdmin.lien.chiffreAffaire"/></html:link></li>
	<li><html:link action="/nombreAnnonces.do"><bean:message key="menuAdmin.lien.nombreAnnonces"/></html:link></li>
	<li><html:link action="/gestionCategorie.do"><bean:message key="menuAdmin.lien.gestionCategorie"/></html:link></li>
	<li><html:link action="/gestionAnnoncesDouteuses.do"><bean:message key="menuAdmin.lien.gestionAnnoncesDouteuses"/></html:link></li>
</ul>
