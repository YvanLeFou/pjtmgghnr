<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>

<%@attribute name="action" required="true"%>
<%@attribute name="modification" required="true"%>

<html:form action="${pageScope.action}"> 
	<fieldset>
		<legend><bean:message key="inscription.legend.creerCompte"/></legend>
		
		<label for="pseudo"><bean:message key="inscription.legend.creerCompte.pseudo"/></label>
		<html:text disabled="${ pageScope.modification }" property="pseudo" styleId="pseudo"></html:text><br/>
		<div id="erreur"><html:errors property="inscription.pseudo.vide"/></div>
		<div id="erreur"><html:errors property="inscription.pseudo.pris"/></div>
		
		<logic:equal value="true" name="modification">
			<label for="mdpActuel"><bean:message key="inscription.legend.creerCompte.mdp.actuel"/></label>
			<html:password property="mdpActuel" styleId="mdpActuel"/><br/>
			<div id="erreur"><html:errors property="inscription.mdp.actuel.vide"/></div>
			<div id="erreur"><html:errors property="inscription.mdp.mod"/></div>
		</logic:equal>
		
		<label for="mdp1"><bean:message key="inscription.legend.creerCompte.mdp"/></label>
		<html:password property="mdp" styleId="mdp1"/><br/>
		<div id="erreur"><html:errors property="inscription.mdp.vide"/></div>
		
		<label for="mdp2"><bean:message key="inscription.legend.creerCompte.mdp2"/></label>
		<html:password property="mdp2" styleId="mdp2"/><br/>
		<div id="erreur"><html:errors property="inscription.mdp2.vide"/></div>
		<div id="erreur"><html:errors property="inscription.mdp.identique"/></div>
	</fieldset>
	
	<fieldset>
		<legend><bean:message key="inscription.legend.infoperso"/></legend>
		
		<label for="nom"><bean:message key="inscription.legend.infoperso.nom"/></label>
		<html:text property="nom" styleId="nom"></html:text><br/>
		<div id="erreur"><html:errors property="inscription.nom.vide"/></div>
				
		<label for="prenom"><bean:message key="inscription.legend.infoperso.prenom"/></label>
		<html:text property="prenom" styleId="prenom"></html:text><br/>
		<div id="erreur"><html:errors property="inscription.prenom.vide"/></div>
		
		<label for="numRue"><bean:message key="inscription.legend.infoperso.numrue"/></label>
		<html:text property="numeroRue" styleId="numRue"></html:text><br/>
		<div id="erreur">
			<html:errors property="inscription.numrue.vide"/>
			<html:errors property="inscription.numrue.invalide"/>
		</div>

		<label for="rue"><bean:message key="inscription.legend.infoperso.rue"/></label>
		<html:text property="nomRue" styleId="rue"></html:text><br/>
		<div id="erreur"><html:errors property="inscription.nomrue.vide"/></div>
		
		<label for="cp"><bean:message key="inscription.legend.infoperso.cp"/></label>
		<html:text property="cp" styleId="cp"></html:text><br/>
		<div id="erreur"><html:errors property="inscription.cp.vide"/></div>
		<div id="erreur"><html:errors property="inscription.cp.invalide"/></div>
			
		<label for="ville"><bean:message key="inscription.legend.infoperso.ville"/></label>
		<html:text property="ville" styleId="ville"></html:text><br/>
		<div id="erreur"><html:errors property="inscription.ville.vide"/></div>
		
		<label for="reg"><bean:message key="inscription.legend.infoperso.region"/></label>
		<html:select property="region" styleId="reg" onchange="change();" >
			<html:option value=""></html:option>
			<html:options collection="listRegion" property="idRegion" labelProperty="libelle"/>
		</html:select><br/>
		<div id="erreur"><html:errors property="inscription.region.vide"/></div>
				
		<label for="dept"><bean:message key="inscription.legend.infoperso.departement"/></label>
		<html:select property="departement" styleId="dept">				
		</html:select>
		<html:hidden property="departement" styleId="mdept" /><br/>
		<div id="erreur"><html:errors property="inscription.dpt.vide"/></div>
		
		<label for="mail"><bean:message key="inscription.legend.infoperso.mail"/></label>
		<html:text property="email" styleId="mail"></html:text><br/>
		<div id="erreur"><html:errors property="inscription.mail.vide"/></div>
		<div id="erreur"><html:errors property="inscription.mail.invalide"/></div>
		
		<label for="telephone"><bean:message key="inscription.legend.infoperso.tel"/></label>
		<html:text property="telephone" styleId="telephone"></html:text><br/>
		<div id="erreur"><html:errors property="inscription.tel.vide"/></div>
		<div id="erreur"><html:errors property="inscription.tel.invalide"/></div>
	</fieldset>
	<html:submit styleClass="btn"><bean:message key="bouton.submit.inscription"/></html:submit>
	<html:reset styleClass="btn"><bean:message key="bouton.reset"/></html:reset>
</html:form>