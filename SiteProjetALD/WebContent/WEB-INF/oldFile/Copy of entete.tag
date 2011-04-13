
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>

<div id="entete">
	<div id="banniere">Chez Olive</div>
	<div id="formuRapide">
		<logic:empty name="pseudo" scope="session">
			<html:form action="/connexion.do">
				<table>
					<tr>
						<td>
							<label for="pseudo"><bean:message key="entete.pseudo"/></label>
						</td>
						<td>
							<html:text property="pseudo" styleId="pseudo"></html:text>
						</td>
						<td><span id="erreur"><html:errors property="connexion.pseudo.vide"/></span></td>
					</tr>
					<tr>
						<td>
							<label for="mdp"><bean:message key="entete.mdp"/></label>
						</td>
						<td>
							<html:password property="mdp" styleId="mdp"></html:password>
						</td>
						<td><span id="erreur"><html:errors property="connexion.mdp.vide"/></span></td>
					</tr>
					<tr>
						<td><html:submit><bean:message key="bouton.submit.connexion"/></html:submit></td>
						<td><html:reset><bean:message key="bouton.reset"/></html:reset></td>
					</tr>
					<tr><td><html:link action="/inscription.do"><bean:message key="entete.lien.inscription"/></html:link></td></tr>
				</table>
			</html:form>
		</logic:empty>
		
		<logic:notEmpty name="pseudo" scope="session">
			<bean:message key="entete.presentation"/><bean:write name="pseudo" scope="session" property="pseudo"/><br/>
			<html:link action="/creationCompte.do?prior"><bean:message key="entete.lien.creationCompte"/></html:link><br/>
			<html:link action="/deconnexion.do"><bean:message key="entete.lien.deconnexion"/></html:link>
		</logic:notEmpty>
	</div>
</div>