<%@ include file="../../entete.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel=stylesheet type="text/css" href="style.css"/>
		<title><bean:message key="inscription.title"/></title>
		
		<script type="text/javascript" src="jquery.js"></script>
		<script type="text/javascript">
			function change(majSelectDept) {
				var data = $("#reg").val();
				
				$.ajax({
					url : 'ajaxAction.do',
					data : "data=" + data,
					type : "GET",
					dataType : "html",
					cache : false,
					success : function(data) {
						$('#dept').html(data);
					},
					error : function(XMLHttpRequest, textStatus, errorThrown) {
						alert("erreur : " + textStatus + "\n" + errorThrown);
					},
					complete : function() {
						if (majSelectDept) {
							var idDepartement = $('#mdept').val();
							var select = $('#dept option');
							select.each(function(index, value) {
								var valueOption = value.getAttribute('value');
								if (valueOption == idDepartement) {
									//selecteur sur la value 
									$('#dept option:eq('+index+')').attr("selected", "selected");
								}
							});
						}
					}
				});
			}
			
			$(function() {
				var data = $("#reg").val();
				if (data != "")
					change(true);
			});
		</script>
	</head>
	
	<body>
		<tags:entete/>
		<tags:lateral/>
		
		<div id="corps">
			<fieldset>
				<legend><bean:message key="inscription.legend"/></legend>
				<html:form action="/creationCompte.do" styleId="myform">
					<fieldset>
						<legend><bean:message key="inscription.legend.creerCompte"/></legend>
						<table>
							<tr>
								<td><label for="pseudo"><bean:message key="inscription.legend.creerCompte.pseudo"/></label></td>
								<td><html:text property="pseudo" styleId="pseudo"></html:text></td>
								<td><span id="erreur"><html:errors property="inscription.pseudo.vide"/></span></td>
							</tr>
							
							<tr>
								<td><label for="mdp1"><bean:message key="inscription.legend.creerCompte.mdp"/></label></td>
								<td><html:password property="mdp" styleId="mdp1"/></td>
								<td><span id="erreur"><html:errors property="inscription.mdp.vide"/></span></td>
							</tr>
							
							<tr>
								<td><label for="mdp2"><bean:message key="inscription.legend.creerCompte.mdp2"/></label></td>
								<td><html:password property="mdp2" styleId="mdp2"/></td>
								<td><span id="erreur"><html:errors property="inscription.mdp2.vide"/></span></td>
							</tr>
							
							<tr>
								<td><span id="erreur"><html:errors property="inscription.mdp.identique"/></span></td>
							</tr>
						</table>
					</fieldset>
					
					<fieldset>
						<legend><bean:message key="inscription.legend.infoperso"/></legend>
						<table>
							<tr>
								<td><label for="nom"><bean:message key="inscription.legend.infoperso.nom"/></label></td>
								<td><html:text property="nom" styleId="nom"></html:text></td>
								<td><span id="erreur"><html:errors property="inscription.nom.vide"/></span></td>
								
								<td><label for="prenom"><bean:message key="inscription.legend.infoperso.prenom"/></label></td>
								<td><html:text property="prenom" styleId="prenom"></html:text></td>
								<td><span id="erreur"><html:errors property="inscription.prenom.vide"/></span></td>
							</tr>
							
							<tr>
								<td><label for="numRue"><bean:message key="inscription.legend.infoperso.numrue"/></label></td>
								<td><html:text property="numeroRue" styleId="numRue"></html:text></td>
								<td>
									<span id="erreur">
										<html:errors property="inscription.numrue.vide"/>
										<html:errors property="inscription.numrue.invalide"/>
									</span>
								</td>
								
								<td><label for="rue"><bean:message key="inscription.legend.infoperso.rue"/></label></td>
								<td><html:text property="nomRue" styleId="rue"></html:text></td>
								<td><span id="erreur"><html:errors property="inscription.nomrue.vide"/></span></td>
							</tr>
							
							<tr>
								<td><label for="cp"><bean:message key="inscription.legend.infoperso.cp"/></label></td>
								<td><html:text property="cp" styleId="cp"></html:text></td>
								<td><span id="erreur"><html:errors property="inscription.cp.vide"/></span></td>
							
								<td><label for="ville"><bean:message key="inscription.legend.infoperso.ville"/></label></td>
								<td><html:text property="ville" styleId="ville"></html:text></td>
								<td><span id="erreur"><html:errors property="inscription.ville.vide"/></span></td>
							</tr>
							
							<tr>
								<td><label for="reg"><bean:message key="inscription.legend.infoperso.region"/></label></td>
								<td>
									<html:select property="region" styleId="reg" onchange="change();" >
										<html:option value=""></html:option>
										<html:options collection="listRegion" property="idRegion" labelProperty="libelle"/>
									</html:select>
								</td>
								<td><span id="erreur"><html:errors property="inscription.region.vide"/></span></td>
								
								<td><label for="dept"><bean:message key="inscription.legend.infoperso.departement"/></label></td>
								<td>
									<html:select property="departement" styleId="dept">
										
									</html:select>
									<html:hidden property="departement" styleId="mdept" />
								</td>
								<td><span id="erreur"><html:errors property="inscription.dpt.vide"/></span></td>
							</tr>
							
							<tr>
								<td><label for="mail"><bean:message key="inscription.legend.infoperso.mail"/></label></td>
								<td><html:text property="email" styleId="mail"></html:text></td>
								<td><span id="erreur"><html:errors property="inscription.mail.vide"/></span></td>
								
								<td><label for="telephone"><bean:message key="inscription.legend.infoperso.tel"/></label></td>
								<td><html:text property="telephone" styleId="telephone"></html:text></td>
								<td><span id="erreur"><html:errors property="inscription.tel.vide"/></span></td>
							</tr>
						</table>
					</fieldset>
					<table>
						<tr>
							<td><html:submit><bean:message key="bouton.submit.inscription"/></html:submit></td>
							<td><html:reset><bean:message key="bouton.reset"/></html:reset></td>
						</tr>
					</table>
				</html:form>
			</fieldset>
		</div>
	</body>
</html>
