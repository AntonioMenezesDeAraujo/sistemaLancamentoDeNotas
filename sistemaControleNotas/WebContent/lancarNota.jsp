<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Lançamento de Notas</title>
<link rel="stylesheet" type="text/css" href="<c:url value="estilo.css" />"/>
</head>
<body>
	<div id="id" class="geral">
		<jsp:include page="cabecalho.html" />
		
		<form class="formulario" action="AlunoServlet?parametro=ServicoLancarNota" name="formulario" method="post">
			<%
				Aluno aluno = (Aluno)request.getAttribute("alunoSelecionado");
				List<Avaliacao> avaliacoes = (List<Avaliacao>)request.getAttribute("avaliacoesSelecionada");
	 		%>
	 		
	 		<p><label>Selecione a Avaliação que deseja lançar a nota: </label></p>
			<select size="1" name="avaliacao">
				<option selected value="Selecione">Selecione a avaliação</option>
				<%for(Avaliacao avaliacao : avaliacoes){ %>
					<option><%= avaliacao.getDescricao() %></option>
				<%} %>
			</select>
			<p><label>Nome:</label> <input type="text" size="20" name="nome" value="<%= aluno.getNome() %>" /></p>
			<p><label>Matrícula:</label> <input type="text" size="20" name="mat" value="<%= aluno.getMatricula() %>" /></p>
			<p><label>Nota:</label> <input type="text" size="20" name="nota" /></p>
			<p> 
				<input type="submit" value="Lançar" /> 
				<a href="index.jsp" class="button">Voltar</a>
			</p>
		</form>
	</div>
</body>
</html>

