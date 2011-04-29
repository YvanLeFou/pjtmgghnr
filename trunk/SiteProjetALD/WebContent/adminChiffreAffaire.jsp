<%@include file="entete.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel=stylesheet type="text/css" href="style.css"/>
		<title><bean:message key="chiffreAffaire.title"/></title>
	</head>
	
	<body>
		<tags:adminEntete/>
		<tags:adminLateral/>
		
		<div id="corps">
		<logic:present name="pseudo" scope="session">
			<h1><bean:message key="chiffreAffaire.title"/></h1>
			<bean:message key="chiffreAffaire.libelleEnCours"/>
			&nbsp;:&nbsp;<bean:write name="caEnCours"/>&nbsp;<bean:message key="chiffreAffaire.unite"/><br><br>
			<label><bean:message key="chiffreAffaire.libelleDerniersMois"/></label><br><br>
			<table border="1">
				<tr>
				<logic:iterate id="element" name="caDerniersMois">
					<th><bean:write name="element" property="key"/></th>
				</logic:iterate>
				</tr>
				<tr>
				<logic:iterate id="element" name="caDerniersMois">
					<th><bean:write name="element" property="value"/></th>
				</logic:iterate>
				</tr>		
			</table>
		</logic:present>
		</div>
	</body>
</html>