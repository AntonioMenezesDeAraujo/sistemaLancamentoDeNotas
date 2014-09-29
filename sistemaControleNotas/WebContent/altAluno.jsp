<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Alterar Aluno</title>
<link rel="stylesheet" type="text/css" href="<c:url value="estilo.css" />"/>

</head>
<body>
<div class="geral">
	 <jsp:include page="cabecalho.html" />
	 <%
		String erro = request.getParameter("erro");
	 	String matricula = request.getParameter("matricula");
	 	String nome = request.getParameter("nome");
	 %>
     	<form class="formulario" action="AlunoServlet?parametro=ServicoAlterarAluno" method="post">
			<%
				if(erro != null && !erro.isEmpty()){
					out.print("<div class=\"error\">" + erro + "</div>");
				}
	 		%>
			<p>
				<label>Nome:</label>
				<input type="text" size="20" name="nomeAlterado" value="<%= nome %>"/>
			</p>
						
			<p>
				<input  type="submit" value="Alterar"></input>
				<a href="conAluno.jsp" class="button">Voltar</a>
			</p>
			
			<input  type="hidden" name="matriculaOriginal" value="<%= matricula %>"/>
			<input  type="hidden" name="nomeOriginal" value="<%= nome %>"/>
		</form>
	</div>
</body>
</html>