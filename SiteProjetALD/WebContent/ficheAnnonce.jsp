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
				<label><bean:message key="ficheAnnonce.prixactu"/></label><bean:write name="annonce" property="miseAPrix" /><br/>
<%-- 				<label><bean:message key="ficheAnnonce.prixactu"/></label>	<label> --%>
<%-- 																				<logic:present name="oenchere" scope="request"> --%>
<%-- 																					<bean:write name="oenchere" property="prix"/><!-- <br/>(<bean:write name="oenchere" property="date" format="dd MMMM yyyy"/>) --> --%>
<%-- 																				</logic:present> --%>
<%-- 																				<logic:notPresent name="oenchere" scope="request"> --%>
<%-- 																					<bean:write name="annonce" property="miseAPrix" /> --%>
<%-- 																				</logic:notPresent> --%>
<!-- 																			</label><br/> -->
				<%--<label><bean:message key="ficheAnnonce.datefin"/></label><bean:write name="annonce" property="dateFin" format="EEEEE dd MMMM yyyy HH:mm:ss"/><br/> --%>
				<label><bean:message key="ficheAnnonce.datefin"/></label><bean:write name="annonce" property="dateFin" format="EEEEE dd MMMM yyyy"/><br/>
			</div>
			
			<div id="infoVendeur">
				<label><bean:message key="ficheAnnonce.vendeur"/></label>
				<label><bean:write name="internaute" property="pseudo" /></label>
				<logic:equal value="1" name="annonce" property="joignable">
					<label><bean:message key="ficheAnnonce.tel"/></label><bean:write name="internaute" property="telephone" /><br/>
				</logic:equal>
				<label><bean:message key="ficheAnnonce.mail"/></label><bean:write name="internaute" property="email" /><br/>
				
				<html:form action="/identiteIntenaute.do">
					<html:hidden property="idOffre" write="idOffre" name="annonce"/>
					<logic:notPresent name="typeAff">
							<html:submit value="Information Complémentaire" style="width:100%;" styleClass="btn"></html:submit>
					</logic:notPresent>
				</html:form><br/>
				
				<logic:notPresent name="typeAff">
					<html:form action="/signaler.do">
						<html:hidden property="idOffre" write="idOffre" name="annonce" />
						<html:submit value="Signaler cette annonce" style="width:100%;" styleClass="btn"/><br/>
					</html:form>
				</logic:notPresent>
			</div>
			
			<logic:notPresent name="typeAff">
				<div id="enchere">
					<logic:lessEqual value="0" name="dateAujourdhui">
						<html:form action="/proposeenchere.do">
							<label style="width:20%;"><bean:message key="ficheAnnonce.enchere"/></label>
							<html:text property="enchere" style="width:20%; margin-right:5%;" />
							<html:hidden property="idOffre" write="idOffre" name="annonce"/>
							<html:submit value="Encherir" style="width:30%" styleClass="btn"/><br/><br/>
							<div id="erreur"><html:errors property="enchere.invalide"/></div>
							<div id="erreur"><html:errors property="enchere.insuffisant"/></div>
							<div id="erreur"><html:errors property="enchere.internaute.identique"/></div>
						</html:form>
					</logic:lessEqual>
				</div>
			</logic:notPresent>
			
			<div id="description">
				<bean:message key="ficheAnnonce.description"/><br/>
				<bean:write name="annonce" property="descriptif"/><br/>
			</div>
			
			<div>
				<logic:iterate id="img" name="annonce" property="image">
					<img src="<bean:write name="img" property="libelleImage"/>" alt="<bean:write name="img" property="libelleImage"/>" />
				</logic:iterate><br/>
			</div>
			
			<logic:equal value="visu" name="typeAff">
				<div>
					<html:link action="/retour.do?prior" styleClass="btn" style="width: 45%; float: left;text-align:center;">Retour</html:link>
					<html:link action="/ajouterAnnonceVisualise.do" styleClass="btn" style="width: 45%; float: right;text-align:center;">Valider l'offre</html:link>
				</div>
			</logic:equal>
		</div>
	</body>
</html>