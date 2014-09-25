<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Lançamento de notas</title>
<link rel="stylesheet" type="text/css" href="<c:url value="estilo.css" />"/>
</head>
<body>
	<div id="id" class="geral">
		<jsp:include page="cabecalho.html" />
		
		<form class="formulario" action="AlunoServlet?parametro=ServicoPesquisarAluno" name="formulario" method="post">
			
			<p><label>Digite a matrícula:</label> <input type="text" size="20" name="mat" /></p>
			
			<p> 
				<input type="submit" value="Pesquisar" /> 
				<input type="reset" value="Cancelar" />
			</p>
		</form>
	</div>
</body>
</html>

