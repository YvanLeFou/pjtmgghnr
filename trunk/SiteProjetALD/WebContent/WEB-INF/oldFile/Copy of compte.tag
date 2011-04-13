<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>

<%-- dans ce fichier tous liens du menu devront avoir la forme /action.do?prior --%>
<h1>Mon Compte</h1>
<ul>
	<li><html:link action="/creationCompte.do?prior">Modifier mes données</html:link></li>
	<li>En cours
		<ul>
			<li>Enchères</li>
			<li>Ventes</li>
		</ul>
	</li>
	<li>Historique
		<ul>
			<li>Achats</li>
			<li>Ventes</li>
		</ul>
	</li>
	
	<li>Poster une annonce</li>
	<li>Supprimer mon compte</li>
	<li><html:link action="/index.do">revenir à la recherche</html:link></li>
</ul>
