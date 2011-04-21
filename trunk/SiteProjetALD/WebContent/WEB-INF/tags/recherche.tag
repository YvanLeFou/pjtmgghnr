<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>

<h1><bean:message key="menu.titre"/></h1>
<html:form action="recherche.do">
	<fieldset>
		<legend><bean:message key="menu.legend.basique"/></legend>
		<label for="motcle"><bean:message key="menu.legend.basique.keyword"/></label>
		<html:text property="motclef" styleId="motcle"></html:text><br/>
		
		<label for="categ"><bean:message key="menu.legend.basique.categ"/></label>
		<html:select property="categorie" styleId="categ">
			<html:option value=""></html:option>
			<html:options collection="listCategorie" property="idCategorie" labelProperty="libelle"/>
		</html:select><br/>
	</fieldset>
	
	<fieldset>
		<legend><bean:message key="menu.legend.option"/></legend>
		
		<label for="dpt"><bean:message key="menu.legend.option.departement"/></label>
		<html:select property="departementSelect" styleId="dpt">
			<html:option value=""></html:option>
			<html:options collection="listDepartement" property="idDepartement" labelProperty="libelleDepartement"/>
		</html:select><br/>
		
		<label for="min"><bean:message key="menu.legend.option.prixmin"/></label>
		<html:text property="min" styleId="min"></html:text><br/>
		<div id="erreur"><html:errors property="recherche.min.invalide"/></div>
		
		<label for="max"><bean:message key="menu.legend.option.prixmax"/></label>
		<html:text property="max" styleId="max"></html:text><br/>
		<div id="erreur"><html:errors property="recherche.max.invalide"/></div>
	</fieldset>
	
	<html:submit styleClass="btn"><bean:message key="bouton.submit.rechercher"/></html:submit>
	<html:reset styleClass="btn"><bean:message key="bouton.reset"/></html:reset>
</html:form>

