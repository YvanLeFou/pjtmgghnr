<%@ include file="entete.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="style.css" type="text/css" />
		<title><bean:message key="erreur.titlePage"/></title>
	</head>
	
	<body>
		<tags:entete/>
		<tags:lateral/>
		<div id="corps">
			<h1><bean:message key="erreur.title"/></h1>
			<span id="erreur"><html:errors/></span>
		</div>
	</body>
</html>