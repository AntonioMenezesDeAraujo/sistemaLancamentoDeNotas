<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Excluir Aluno</title>
<link rel="stylesheet" type="text/css" href="<c:url value="estilo.css" />"/>

</head>
<body>
<div class="geral">
	   <jsp:include page="cabecalho.html" />
	   <%
	   		String nome = request.getParameter("nome");
	  		String matricula = request.getParameter("matricula");
	   %>
     	<form class="formulario" action="AlunoServlet?parametro=ServicoExcluirAluno" method="post">
			<p>
				<label>Nome:</label>
				<input type="text" size="20" name="nome" value = "<%= nome%>" />
			</p>
			
			<p>
				<label>Matr�cula:</label>
				<input type="text" size="20" name="mat" value = "<%= matricula %>" /> 
			</p>
			
			<p>
				<input  type="submit" value="Excluir"></input>
				<input  type="reset" value="Limpar"></input>
			</p>
		</form>
	</div>
</body>
</html>