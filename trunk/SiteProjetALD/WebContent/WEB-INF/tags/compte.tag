<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>

<%-- dans ce fichier tous liens du menu devront avoir la forme /action.do?prior --%>
<h1><bean:message key="compte.titre"/></h1>
<ul>
	<li><html:link action="/modificationCompte.do?prior"><bean:message key="compte.lien.modifierCompte"/></html:link></li>
	<li><bean:message key="compte.lien.encours"/>
		<ul>
			<li><bean:message key="compte.lien.encours.enchere"/></li>
			<li><bean:message key="compte.lien.encours.vente"/></li>
		</ul>
	</li>
	<li><bean:message key="compte.lien.historique"/>
		<ul>
			<li><bean:message key="compte.lien.historique.achat"/></li>
			<li><bean:message key="compte.lien.historique.vente"/></li>
		</ul>
	</li>
	
	<li><bean:message key="compte.lien.posterAnnonce"/></li>
	<li><bean:message key="compte.lien.supprimerCompte"/></li>
	<li><html:link action="/index.do"><bean:message key="compte.lien.index"/></html:link></li>
</ul>
