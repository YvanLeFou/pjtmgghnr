<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>

<div id="entete">
	<div id="banniere">Chez Olive
	<img src="olive.gif" height="145px"/>
	</div>
	<div id="formuRapide">
		<logic:empty name="pseudo" scope="session">
			<html:form action="/adminConnexion.do">
				<label for="pseudo"><bean:message key="entete.pseudo"/></label>
				<html:text property="pseudo" styleId="pseudo"></html:text><br/>
				<div id="erreur"><html:errors property="connexion.pseudo.vide"/></div>
				
				<label for="mdp"><bean:message key="entete.mdp"/></label>
				<html:password property="mdp" styleId="mdp"></html:password><br/>
				<div id="erreur"><html:errors property="connexion.mdp.vide"/></div>
				
				<html:submit styleClass="btn"><bean:message key="bouton.submit.connexion"/></html:submit>
				<html:reset  styleClass="btn"><bean:message key="bouton.reset"/></html:reset><br/>
				
				<div id="erreur"><html:errors property="entete.admin.introuvable"/></div>
				<div id="erreur"><html:errors property="entete.connexion"/></div>
			</html:form>
		</logic:empty>
		
		<logic:notEmpty name="pseudo" scope="session">
			<bean:message key="entete.presentation"/><bean:write name="pseudo" scope="session" property="pseudo"/><br/>
			<html:link action="/adminDeconnexion.do"><bean:message key="entete.lien.deconnexion"/></html:link>
		</logic:notEmpty>
	</div>
</div>