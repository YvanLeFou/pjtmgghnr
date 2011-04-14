<%@include file="entete.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel=stylesheet type="text/css" href="style.css"/>
		<title><bean:message key="postAnnonce.title"/></title>
	</head>
	
	<body>
		<tags:entete/>
		<tags:lateral/>
		
		<div id="corps">
			<bean:message key="postAnnonce.titre"/><br/>
			<html:form action="/posterAnnonce.do?prior" enctype="multipart/form-data">
				<label><bean:message key="postAnnonce.photo"/></label><html:file property="fileList"></html:file><br/>
				<div id="erreur"><html:errors property="postAnnonce.img.vide"/></div>
				
				<label><bean:message key="postAnnonce.nom"/></label><html:text property="titre"></html:text><br/>
				<div id="erreur"><html:errors property="postAnnonce.titre.vide"/></div>
				
				<label><bean:message key="postAnnonce.description"/></label><html:text property="description"></html:text><br/>
				<div id="erreur"><html:errors property="postAnnonce.description.vide"/></div>
				
				<label><bean:message key="postAnnonce.datefin"/></label><html:text property="dateFin"></html:text><br/>
				<div id="erreur">
					<html:errors property="postAnnonce.date.vide"/>
					<html:errors property="postAnnonce.date.invalideFormat"/>
				</div>
				
				<label><bean:message key="postAnnonce.miseaprix"/></label><html:text property="miseAPrix"></html:text><br/>
				<div id="erreur"><html:errors property="postAnnonce.map.vide"/></div>
				
				<label><bean:message key="postAnnonce.voirtel"/></label><html:checkbox property="joignable"></html:checkbox><br/>
				
				<html:submit><bean:message key="bouton.submit.inscription"/></html:submit>
				<html:reset><bean:message key="bouton.reset"/></html:reset>
			</html:form>
		</div>
	</body>
</html>