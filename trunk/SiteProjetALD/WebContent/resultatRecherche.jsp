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
			mots clefs saisi : <bean:write property="motclef" name="formuRecherche"/><br/>
			categorie de recherche : <bean:write property="categorie" name="formuRecherche"/><br/>
			departement selectionne : <bean:write property="departementSelect" name="formuRecherche"/><br/>
			prix min : <bean:write property="min" name="formuRecherche"/><br/>
			prix max : <bean:write property="max" name="formuRecherche"/><br/>
		</div>
	</body>
</html>