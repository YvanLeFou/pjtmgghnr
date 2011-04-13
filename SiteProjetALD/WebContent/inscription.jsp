<%@ include file="entete.jsp" %>
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
				
				<logic:present parameter="prior">
					<tags:form action="/modificationCompte.do?prior" />
				</logic:present>
				
				<logic:notPresent parameter="prior">
					<tags:form action="/creationCompte.do" />
				</logic:notPresent>
			</fieldset>
		</div>
	</body>
</html>
