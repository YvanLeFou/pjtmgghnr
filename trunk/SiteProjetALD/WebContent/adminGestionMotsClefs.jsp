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
	
	<fieldset><legend>
		<bean:message key="adminGestionMotsClefs.titre.creation" /></legend>
		<html:form action="/adminAjouterMotClef.do">
			<label><bean:message key="adminGestionMotsClefs.tableau.libelle" /></label>
			<html:text property="libelleMotClef" size="30" maxlength="50"></html:text><br>
			
			<html:submit styleClass="btn"><bean:message key="bouton.ajouter"/></html:submit>			
		</html:form>
	</fieldset>
	
	<fieldset>
	<legend>
		<bean:message key="adminGestionMotsClefs.titre.suppression" /></legend>
		<table border="1">
			<tr>
				<th><bean:message key="adminGestionMotsClefs.tableau.libelle" /></th>
				<th width=30><img border=none src="icone_poubelle.gif"></th>
			</tr>
			<logic:iterate id="list" name="motsClefs">
				<tr>
					<td><bean:write name="list" property="libelleMotClef" /></td>
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