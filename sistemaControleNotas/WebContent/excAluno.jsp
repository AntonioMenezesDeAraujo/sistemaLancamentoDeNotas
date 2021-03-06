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
			<p>Deseja realmente excluir o registro abaixo?</p>
			<p>
				<label>Matrícula:</label>
				<input type="text" size="20" name="mat" value = "<%= matricula %>" readonly="readonly" /> 
			</p>
			<p>
				<label>Nome:</label>
				<input type="text" size="20" name="nome" value = "<%= nome%>" readonly="readonly" />
			</p>
			<p>
				<input  type="submit" value="Excluir"></input>
				<a href="conAluno.jsp" class="button">Voltar</a>
			</p>
		</form>
	</div>
</body>
</html>