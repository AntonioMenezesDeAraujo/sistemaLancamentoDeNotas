<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Lan�amento de Notas</title>
<link rel="stylesheet" type="text/css" href="<c:url value="estilo.css" />"/>
</head>
<body>
	<div id="id" class="geral">
		<jsp:include page="cabecalho.html" />
		<%
		   String erro = request.getParameter("erro");
	 	%>
		<form class="formulario" action="AlunoServlet?parametro=ServicoLancarNota" name="formulario" method="post">
			<%
				if(erro != null && !erro.isEmpty()){
					out.print("<div class=\"error\">" + erro + "</div>");
				}
				Aluno aluno = (Aluno)request.getAttribute("alunoSelecionado");
				List<Avaliacao> avaliacoes = (List<Avaliacao>)request.getAttribute("avaliacoesSelecionada");
	 		%>
	 		
	 		<p><label>Selecione a Avalia��o que deseja lan�ar a nota: </label></p>
			<select size="1" name="avaliacao">
				<option selected value="Selecione">Selecione a avalia��o</option>
				<%for(Avaliacao avaliacao : avaliacoes){ %>
					<option><%= avaliacao.getDescricao() %></option>
				<%} %>
			</select>
			<p><label>Nome:</label> <input type="text" size="20" name="nome" value="<%= aluno.getNome() %>" readonly="readonly" /></p>
			<p><label>Matr�cula:</label> <input type="text" size="20" name="mat" value="<%= aluno.getMatricula() %>" readonly="readonly" /></p>
			<p><label>Nota:</label> <input type="text" size="20" name="nota" /></p>
			<p> 
				<input type="submit" value="Lan�ar" /> 
				<a href="lancNotas.jsp" class="button">Voltar</a>
			</p>
		</form>
	</div>
</body>
</html>

