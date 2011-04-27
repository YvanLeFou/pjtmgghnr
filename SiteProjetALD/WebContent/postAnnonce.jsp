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
			<html:form action="/posterAnnonce.do?prior" enctype="multipart/form-data" style= "width:100%">
				<label><bean:message key="postAnnonce.photo"/></label><html:file property="fileList"></html:file><br/>
				<div id="erreur"><html:errors property="postAnnonce.img.vide"/></div>
				
				<label><bean:message key="postAnnonce.nom"/></label><html:text property="titre"></html:text><br/>
				<div id="erreur"><html:errors property="postAnnonce.titre.vide"/></div>
				
				<label><bean:message key="postAnnonce.description"/></label><html:textarea property="description"></html:textarea><br/>
				<div id="erreur"><html:errors property="postAnnonce.description.vide"/></div>
				
				<label><bean:message key="menu.legend.basique.categ"/></label>
				<html:select property="categorie">
					<html:options collection="listCategorie" property="idCategorie" labelProperty="libelle"/>
				</html:select><br/>
				
				<label><bean:message key="menu.legend.option.departement"/></label>
				<html:select property="departement">
					<html:options collection="listDepartement" property="idDepartement" labelProperty="libelleDepartement"/>
				</html:select><br/>
				
				<label title="<bean:message key="postAnnonce.datedeb.info"/>"><bean:message key="postAnnonce.datedeb"/></label><html:text property="dateDeb"></html:text><br/>
				<div id="erreur">
					<html:errors property="postAnnonce.datedeb.invalideFormat"/>
				</div>
				
				<label><bean:message key="postAnnonce.datefin"/></label><html:text property="dateFin"></html:text><br/>
				<div id="erreur">
					<html:errors property="postAnnonce.datefin.vide"/>
					<html:errors property="postAnnonce.datefin.invalideFormat"/>
					<html:errors property="postAnnonce.datefin.pbenchere"/>
				</div>
				
				<label><bean:message key="postAnnonce.miseaprix"/></label><html:text property="miseAPrix"></html:text><br/>
				<div id="erreur"><html:errors property="postAnnonce.map.vide"/></div>
				
				<label><bean:message key="postAnnonce.voirtel"/></label><html:checkbox property="joignable"></html:checkbox><br/>
				
				<html:submit styleClass="btn"><bean:message key="bouton.submit.inscription"/></html:submit>
				<html:reset styleClass="btn"><bean:message key="bouton.reset"/></html:reset>
			</html:form>
		</div>
	</body>
</html>