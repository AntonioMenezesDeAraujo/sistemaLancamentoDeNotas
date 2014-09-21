<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Cadastro de Alunos</title>
<link rel="stylesheet" type="text/css" href="<c:url value="estilo.css" />"/>
<link rel="stylesheet" type="text/css" href="<c:url value="estilo.css" />"/>
</head>	
<body>
	<div id="id" class="geral">
		<jsp:include page="cabecalho.html" />
		<form class="formulario" action="AlunoServlet?parametro=ServicoCadastroAluno" name="formulario" method="post">
		
			<p><label>Nome:</label> <input type="text" size="20" name="nome" /></p>
			<p><label>Matrícula:</label> <input type="text" size="20" name="mat" /></p>
			
			<p> 
				<input type="submit" value="Cadastrar" /> 
				<input type="reset" value="Limpar" />
				<a href="index.htm"> <input	type="submit" value="Cancelar" /></a>
			</p>
		</form>
	</div>
<!-- <input type="button" onclick="validaAluno()" value="click" /> -->
</body>
</html>

