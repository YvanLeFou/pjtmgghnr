<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>

<h1><bean:message key="menu.titre"/></h1>
<html:form action="recherche.do">
	<fieldset>
		<legend><bean:message key="menu.legend.basique"/></legend>
		<table>
			<tr>
				<td><label for="motcle"><bean:message key="menu.legend.basique.keyword"/></label></td>
				<td><html:text property="motclef" styleId="motcle"></html:text></td>
			</tr>
			
			<tr>
				<td><label for="categ"><bean:message key="menu.legend.basique.categ"/></label></td>
				<td>
					<html:select property="categorie" styleId="categ">
						<html:option value=""></html:option>
						<html:options collection="listCategorie" property="idCategorie" labelProperty="libelle"/>
					</html:select>
				</td>
			</tr>
		</table>
	</fieldset>
	
	<fieldset>
		<legend><bean:message key="menu.legend.option"/></legend>
		<table>
			<tr>
				<td><label for="dpt"><bean:message key="menu.legend.option.departement"/></label></td>
				<td>
					<html:select property="departementSelect" styleId="dpt">
						<html:option value=""></html:option>
						<html:options collection="listDepartement" property="code" labelProperty="libelleDepartement"/>
					</html:select>
				</td>
			</tr>
			
			<tr>
				<td><label for="min"><bean:message key="menu.legend.option.prixmin"/></label></td>
				<td><html:text property="min" styleId="min"></html:text></td>
			</tr>
			
			<tr>
				<td><label for="max"><bean:message key="menu.legend.option.prixmax"/></label></td>
				<td><html:text property="max" styleId="max"></html:text></td>
			</tr>
		</table>
	</fieldset>
	<table>
		<tr>
			<td><html:submit><bean:message key="bouton.submit.rechercher"/></html:submit></td>
			<td><html:reset><bean:message key="bouton.reset"/></html:reset></td>
		</tr>
	</table>
</html:form>

