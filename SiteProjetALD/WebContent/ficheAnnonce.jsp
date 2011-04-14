<%@include file="entete.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel=stylesheet type="text/css" href="style.css"/>
		
		<title><bean:message key="index.title"/></title>
	</head>
	
	<body>
		<tags:entete/>
		<tags:lateral/>
		
		<div id="corps">
			<div id="image">
				<logic:iterate id="img" name="annonce" property="image">
					<img style="width: 100%; height:100%;" src="<bean:write name="img" property="libelleImage"/>" alt="<bean:write name="img" property="libelleImage"/>" />
				</logic:iterate><br/>
			</div>
			
			<div id="infoAnnonce">
				<bean:write name="annonce" property="titre" /><br/>
				<label>Prix min</label><bean:write name="annonce" property="miseAPrix" /><br/>
				<label>Prix actuel</label>	<logic:iterate id="list" name="annonce" property="encherit">
												<label><bean:write name="list" property="prix" /></label>
											</logic:iterate><br/>
				<label>Date fin</label><bean:write name="annonce" property="dateFin" /><br/>
			</div>
			
			<div id="infoVendeur">
				<label>Vendeur</label>
				<html:form action="/identiteIntenaute.do">
					<label><bean:write name="internaute" property="pseudo" /></label>
					<html:hidden property="idOffre" write="idOffre" name="annonce"/>
					<html:submit value="Information Complémentaire" style="width:100%;"></html:submit><br/>
				</html:form><br/>
				
				<label>tel</label><bean:write name="internaute" property="telephone" /><br/>
				<label>email</label><bean:write name="internaute" property="email" /><br/>
				<html:form action="/signaler.do">
					<html:hidden property="idOffre" write="idOffre" name="annonce" />
					<html:submit value="Signaler cette annonce" style="width:100%;"/><br/>
				</html:form>
			</div>
			
			<!-- ici vaut mieux faire une vérification JS -->
			<div id="enchere">
				<logic:present name="pseudo" scope="session">
					<html:form action="/proposeenchere.do">
						<label style="width:20%;">Enchere</label>
						<html:text property="enchere" style="width:20%; margin-right:5%;" value=""/>
						<html:hidden property="idOffre" write="idOffre" name="annonce"/>
						<html:submit value="Encherir" style="width:30%"/><br/>
						<html:errors property="enchere.invalide"/>
					</html:form>
				</logic:present>
			</div>
			
			<div id="description">
				Description<br/>
				<bean:write name="annonce" property="description"/><br/>
			</div>
		</div>
	</body>
</html>