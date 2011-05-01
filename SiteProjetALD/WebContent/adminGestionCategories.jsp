<%@include file="entete.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel=stylesheet type="text/css" href="style.css" />

<title><bean:message key="adminGestionCategories.title" /></title>
</head>

<body>
<tags:adminEntete />
<tags:adminLateral />

<div id="corps"><logic:present name="pseudo" scope="session">
	
	<!-- Dans le cas d'un ajout de catégorie -->
	<logic:notPresent parameter="Modification">
		<fieldset><legend>
			<bean:message key="adminGestionCategories.titre.creation" /></legend>
			<html:form action="/adminAjouterCategorie.do">
				<label><bean:message key="adminGestionCategories.tableau.libelle" /></label>
				<html:text property="libelleCategorie" size="30" maxlength="50"></html:text><br>
				<div id="erreur"><html:errors property="adminGestionCategories.champsVide"/></div>
				<html:submit styleClass="btn"><bean:message key="bouton.ajouter"/></html:submit>			
			</html:form>
		</fieldset>
	</logic:notPresent>
	
	<!-- Dans le cas d'une modification d'une catégorie -->
	<logic:present parameter="Modification">
		
		<bean:parameter id="id" name="id"/>
		<bean:parameter id="libelle" name="libelle"/>
		
		<fieldset><legend>
			<bean:message key="adminGestionCategories.titre.modification" /></legend>
			<html:form action="/adminModifierCategorie.do">
				<label><bean:message key="adminGestionCategories.tableau.libelle" /></label>
						
				<input type="hidden" name="idCategorie" value="<bean:write name="id"/>"/>
								
				<input type="text" name="libelleCategorie" size="30" maxlength="50" value="<bean:write name="libelle"/>"/><br>
				
				<div id="erreur"><html:errors property="adminGestionCategories.champsVide"/></div>
				
				<html:submit styleClass="btn"><bean:message key="bouton.modifier"/></html:submit>
				<html:link action="/adminGestionCategories.do"><bean:message key="adminGestionCategories.annuler" /></html:link>
			</html:form>
		</fieldset>
	</logic:present>
	
	<fieldset>
	<legend>
		<bean:message key="adminGestionCategories.titre.suppression" /></legend>
		<div id="erreur"><html:errors property="adminGestionCategorie.suppressionImpossible"/></div>
		<table border="1">
			<tr>
				<th><bean:message key="adminGestionCategories.tableau.libelle" /></th>
				<th width=30><img border=none src="a_recycle.gif"></th>
				<th width=30><img border=none src="icone_poubelle.gif"></th>				
			</tr>
			<logic:iterate id="list" name="categories">
				<tr>
					<td><bean:write name="list" property="libelle" /></td>
					<td><html:link
						action="/adminGestionCategories.do?id=${list.idCategorie}&Modification=oui&libelle=${list.libelle}">
						<img border=none src="crayon.gif"/>
					</html:link></td>
					<td><html:link
						action="/adminSuppressionCategorie.do?id=${list.idCategorie}">
						<img border=none src="supprimer.png">
					</html:link></td>
				</tr>
			</logic:iterate>
		</table>
	</fieldset>
</logic:present></div>
</body>
</html>