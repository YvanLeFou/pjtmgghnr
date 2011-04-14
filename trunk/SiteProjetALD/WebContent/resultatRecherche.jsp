<%@include file="entete.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel=stylesheet type="text/css" href="style.css"/>
		<title><bean:message key="resultat.title"/></title>
	</head>
	
	<body>
		<tags:entete/>
		<tags:lateral/>
		
		<div id="corps">
			<table border="1">
				<tr>
					<th></th>
					<th>Nom</th>
					<th>Date</th>
					<th>Prix</th>
				</tr>
				<logic:iterate id="list" name="listRecherche" >
				<tr>
					<td>
						<logic:iterate id="img" name="list" property="image" length="1">
							<img src="<bean:write name="img" property="libelleImage"/>" alt="<bean:write name="img" property="libelleImage"/>" width="50" height="50" />
						</logic:iterate>
					</td>
					<td>
						<html:link action="/identiteAnnonce.do?id=${list.idOffre}">
							<bean:write name="list" property="titre" />
						</html:link>
					</td><!-- il faut ajouter un lien vers le descriptif de l'article -->
					<td><bean:write name="list" property="dateDepot" format="EEEEE dd MMMM yyyy HH:mm:ss"/></td>
					<td><bean:write name="list" property="miseAPrix" /></td>
				</tr>
				</logic:iterate>
			</table>
		</div>
	</body>
</html>