<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Cadastrar Aluno</title>
<link rel="stylesheet" type="text/css" href="<c:url value="estilo.css" />"/>
</head>
<body>
	<div id="id" class="geral">
		<jsp:include page="cabecalho.html" />
		
		<%
	 		String erro = request.getParameter("erro");
			String message = request.getParameter("message");
			String nome = request.getParameter("nome");
			String matricula = request.getParameter("mat");
	 	%>
		
		<form class="formulario" action="AlunoServlet?parametro=ServicoCadastroAluno" name="formulario" method="post">
			<%
				if(message != null && !message.isEmpty()){
					out.print("<div class=\"sucess\">" + message + "</div>");
				}
				if(erro != null && !erro.isEmpty()){
					out.print("<div class=\"error\">" + erro + "</div>");
				}
				
				nome = nome != null ? nome : "";
				matricula = matricula != null ? matricula : "";
	 		%>
			<p><label>Matr�cula:</label> <input type="text" size="20" name="mat" value="<%= matricula %>" /></p>
			<p><label>Nome:</label> <input type="text" size="20" name="nome" value="<%= nome %>" /></p>
			
			<p> 
				<input type="submit" value="Cadastrar" /> 
				<a href="index.jsp" class="button">Voltar</a>
			</p>
		</form>
	</div>
</body>
</html>

