<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<div id="menu">
	<%--
		SI prior est présent dans request ALORS
			SI pseudo est en session ALORS
				affichage du compte
			SINON
				SI pseudo n'est pas en session ALORS
					affichage de recherche
				FSI
			FSI
		SINON
			SI prior n'est dans request ALORS
				afficher recherche
			FSI
		FSI
	 --%>
	<logic:present parameter="prior">
		<logic:present name="pseudo" scope="session">
			<tags:compte/>
		</logic:present>
		<logic:notPresent name="pseudo" scope="session">
			<tags:recherche/>
		</logic:notPresent>
	</logic:present>
	
	<logic:notPresent parameter="prior">
		<tags:recherche/>
	</logic:notPresent>	
</div>
