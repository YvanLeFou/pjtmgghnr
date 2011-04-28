<%@include file="entete.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel=stylesheet type="text/css" href="style.css"/>
		
		<title><bean:message key="index.title"/></title>
	</head>
	
	<body>
		<tags:adminEntete/>
		<tags:adminLateral/>
		
		<div id="corps">
			<p>
				Bonjour vous êtes sur la partie administration.<br/>
				Si vous n'êtes pas administrateur, veuillez sortir s'il vous plait ! :P<br/>
				C'est pas bien de traîner ici ;)<br/>
			</p>
		</div>
	</body>
</html>