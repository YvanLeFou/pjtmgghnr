<%@include file="entete.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel=stylesheet type="text/css" href="style.css"/>
		
		<title><bean:message key="ficheAnnonce.title"/></title>
	</head>
	
	<body>
		<tags:entete/>
		<tags:lateral/>
		
		<div id="corps">
			<div id="image">
				<logic:iterate id="img" name="annonce" property="image" length="1">
					<img style="width: 100%; height:100%;" src="<bean:write name="img" property="libelleImage"/>" alt="<bean:write name="img" property="libelleImage"/>" />
				</logic:iterate><br/>
			</div>
			
			<div id="infoAnnonce">
				<bean:write name="annonce" property="titre" /><br/>
				<label><bean:message key="ficheAnnonce.prixmin"/></label><bean:write name="annonce" property="miseAPrix" /><br/>
				<label><bean:message key="ficheAnnonce.prixactu"/></label>	<label>
																				<logic:present name="enchere" scope="request">
																					<bean:write name="enchere" property="prix"/>(<bean:write name="enchere" property="date" format="dd MMMM yyyy"/>)
																				</logic:present>
																				<logic:notPresent name="enchere" scope="request">
																					<bean:write name="annonce" property="miseAPrix" />
																				</logic:notPresent>
																			</label><br/>
				<%--<label><bean:message key="ficheAnnonce.datefin"/></label><bean:write name="annonce" property="dateFin" format="EEEEE dd MMMM yyyy HH:mm:ss"/><br/> --%>
				<label><bean:message key="ficheAnnonce.datefin"/></label><bean:write name="annonce" property="dateFin" format="EEEEE dd MMMM yyyy"/><br/>
			</div>
			
			<div id="infoVendeur">
				<label><bean:message key="ficheAnnonce.vendeur"/></label>
				<html:form action="/identiteIntenaute.do">
					<label><bean:write name="internaute" property="pseudo" /></label>
					<html:hidden property="idOffre" write="idOffre" name="annonce"/>
					<html:submit value="Information Complémentaire" style="width:100%;"></html:submit><br/>
				</html:form><br/>
				
				<label><bean:message key="ficheAnnonce.tel"/></label><bean:write name="internaute" property="telephone" /><br/>
				<label><bean:message key="ficheAnnonce.mail"/></label><bean:write name="internaute" property="email" /><br/>
				<html:form action="/signaler.do">
					<html:hidden property="idOffre" write="idOffre" name="annonce" />
					<html:submit value="Signaler cette annonce" style="width:100%;"/><br/>
				</html:form>
			</div>
			
			<!-- ici vaut mieux faire une vérification JS -->
			<div id="enchere">
				<logic:present name="pseudo" scope="session">
					<html:form action="/proposeenchere.do">
						<label style="width:20%;"><bean:message key="ficheAnnonce.enchere"/></label>
						<html:text property="enchere" style="width:20%; margin-right:5%;" value=""/>
						<html:hidden property="idOffre" write="idOffre" name="annonce"/>
						<html:submit value="Encherir" style="width:30%"/><br/>
						<div id="erreur"><html:errors property="enchere.invalide"/></div>
					</html:form>
				</logic:present>
			</div>
			
			<div id="description">
				<bean:message key="ficheAnnonce.description"/><br/>
				<bean:write name="annonce" property="descriptif"/><br/>
			</div>
			
			<div>
				<logic:iterate id="img" name="annonce" property="image">
					<img src="<bean:write name="img" property="libelleImage"/>" alt="<bean:write name="img" property="libelleImage"/>" />
				</logic:iterate><br/>
			</div>
		</div>
	</body>
</html>