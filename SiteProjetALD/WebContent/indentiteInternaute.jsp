<%@page import="metier.Internaute"%>
<%@include file="entete.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel=stylesheet type="text/css" href="style.css"/>
		
		<title><bean:message key="identiteInternaute.title"/></title>
	</head>
	
	<body>
		<tags:entete/>
		<tags:lateral/>
		
		<div id="corps">
			<label><bean:message key="identiteInternaute.pseudo"/></label><bean:write name="internaute" property="pseudo"/><br/>
			<label><bean:message key="identiteInternaute.departement"/></label><bean:write name="internaute" property="departement" /><br/>
			<label><bean:message key="identiteInternaute.nbvente"/></label><bean:write name="nbVente"/><br/>
			<label><bean:message key="identiteInternaute.nbachat"/></label><bean:write name="nbAchat"/><br/>
			<label><bean:message key="identiteInternaute.encours"/></label><br/>
			<table border="1">
				<tr>
					<th></th>
					<th><bean:message key="tableau.nom"/></th>
					<th><bean:message key="tableau.date"/></th>
					<th><bean:message key="tableau.prix"/></th>
				</tr>
				<logic:iterate id="list" name="internaute" property="offre">
					<tr>
						<td>
							<logic:iterate id="img" name="list" property="image" length="1">
								<img 
									src="<bean:write name="img" property="libelleImage"/>" 
									alt="<bean:write name="img" property="libelleImage"/>" 
									width="50" 
									height="50" />
							</logic:iterate>
						</td>
						<td>
							<html:link action="/identiteAnnonce.do?id=${list.idOffre}">
								<bean:write name="list" property="titre" />
							</html:link>
						</td>
						<td><bean:write name="list" property="dateDepot" format="EEEEE dd MMMM yyyy HH:mm:ss"/></td>
						<td><bean:write name="list" property="miseAPrix"/></td>
					</tr>
				</logic:iterate>
			</table>
		</div>
	</body>
</html>