<%@include file="entete.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel=stylesheet type="text/css" href="style.css" />

<title><bean:message key="adminAnnoncesDouteuses.title" /></title>
</head>

<body>
<tags:adminEntete />
<tags:adminLateral />

<div id="corps"><logic:present name="pseudo" scope="session">
	<fieldset>
	<legend>
		<bean:message key="adminAnnoncesDouteuses.title" /></legend>
		<table border="1">
			<tr>
				<th><bean:message key="adminAnnoncesDouteuses.offre.titre" /></th>
				<th width=30><img border=none src="valider.png"></th>
				<th width=30><img border=none src="supprimer.png"></th>				
			</tr>
			<logic:iterate id="list" name="annoncesDouteuses">
				<tr>
					<td><bean:write name="list" property="titre" /></td>
					<td><html:link
						action="/adminAnnulerSignalement.do?id=${list.idOffre}">
						<img border=none src="pouce_haut.png"/>
					</html:link></td>
					<td><html:link
						action="/adminValiderSignalement.do?id=${list.idOffre}">
						<img border=none src="pouce_bas.png">
					</html:link></td>
				</tr>
			</logic:iterate>
		</table>
	</fieldset>
</logic:present></div>
</body>
</html>