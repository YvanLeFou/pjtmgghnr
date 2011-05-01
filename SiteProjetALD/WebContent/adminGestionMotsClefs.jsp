<%@include file="entete.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel=stylesheet type="text/css" href="style.css" />

<title><bean:message key="adminGestionMotsClefs.title" /></title>
</head>

<body>
<tags:adminEntete />
<tags:adminLateral />

<div id="corps"><logic:present name="pseudo" scope="session">
	
	<!-- Dans le cas d'un ajout de mot clef -->
	<logic:notPresent parameter="Modification">
		<fieldset><legend>
			<bean:message key="adminGestionMotsClefs.titre.creation" /></legend>
			<html:form action="/adminAjouterMotClef.do">
				<label><bean:message key="adminGestionMotsClefs.tableau.libelle" /></label>
				<html:text property="libelleMotClef" size="30" maxlength="50"></html:text><br>
				
				<div id="erreur"><html:errors property="adminGestionMotsClefs.champsVide"/></div>
				
				<html:submit styleClass="btn"><bean:message key="bouton.ajouter"/></html:submit>			
			</html:form>
		</fieldset>
	</logic:notPresent>
	
	<!-- Dans le cas d'une modification du mot clef -->
	<logic:present parameter="Modification">
		
		<bean:parameter id="id" name="id"/>
		<bean:parameter id="libelle" name="libelle"/>
		
		<fieldset><legend>
			<bean:message key="adminGestionMotsClefs.titre.modification" /></legend>
			<html:form action="/adminModifierMotClef.do">
				<label><bean:message key="adminGestionMotsClefs.tableau.libelle" /></label>
						
				<input type="hidden" name="idMotClef" value="<bean:write name="id"/>"/>
								
				<input type="text" name="libelleMotClef" size="30" maxlength="50" value="<bean:write name="libelle"/>"/><br>
				
				<div id="erreur"><html:errors property="adminGestionMotsClefs.champsVide"/></div>
				
				<html:submit styleClass="btn"><bean:message key="bouton.modifier"/></html:submit>
				<html:link action="/adminGestionMotsClefs.do"><bean:message key="adminGestionMotsClefs.annuler" /></html:link>
			</html:form>
		</fieldset>
	</logic:present>
	
	<fieldset>
	<legend>
		<bean:message key="adminGestionMotsClefs.titre.suppression" /></legend>
		<table border="1">
			<tr>
				<th><bean:message key="adminGestionMotsClefs.tableau.libelle" /></th>
				<th width=30><img border=none src="a_recycle.gif"></th>
				<th width=30><img border=none src="icone_poubelle.gif"></th>				
			</tr>
			<logic:iterate id="list" name="motsClefs">
				<tr>
					<td><bean:write name="list" property="libelleMotClef" /></td>
					<td><html:link
						action="/adminGestionMotsClefs.do?id=${list.idMotClef}&Modification=oui&libelle=${list.libelleMotClef}">
						<img border=none src="crayon.gif"/>
					</html:link></td>
					<td><html:link
						action="/adminSuppressionMotClef.do?id=${list.idMotClef}">
						<img border=none src="supprimer.png">
					</html:link></td>
				</tr>
			</logic:iterate>
		</table>
	</fieldset>
</logic:present></div>
</body>
</html>