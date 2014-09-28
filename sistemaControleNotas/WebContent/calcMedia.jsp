<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AvaliacaoDaoImpl"%>
<%@page import="br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AvaliacaoDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Cálculo da média</title>
<link rel="stylesheet" type="text/css" href="<c:url value="estilo.css" />" />
</head>
<body>
	<div class="geral">
		<jsp:include page="cabecalho.html" />
		<form class="formulario" action="AlunoServlet?parametro=ServicoCalculoMedia" method="post">
			
			<p><input type="radio" name="opcaoSelecionada" value="todasNotas">Calcular a média usando todas as notas</input></p>

			<p><input type="radio" name="opcaoSelecionada" value="notasMaiores">Calcular a média usando notas maiores</input></p>
			
			<p>
				<label style="margin-left: 15px">Quantdidade de notas maiores que irão compor a média</label>
				<input type="text"	size="15" name="qtdNotas" />
			</p>
			
			<p><input type="radio" name="opcaoSelecionada" value="avsSelecionadas">Calcular a média avaliações selecionadas</input></p>
				<%
					AvaliacaoDao dao = new AvaliacaoDaoImpl();
					int op=1;
					List<Avaliacao> avaliacoes = dao.pesquisarAvaliacao(); 
					for(Avaliacao av : avaliacoes){
				%>
				<p><input type="checkbox" name="<%=av.getCodigo()%>" value = "<%=av.getCodigo() %>" style="margin-left: 50px"><%=av.getDescricao() %></input></p>
				<%
					op = op+1;
					} %>
				
				
				<p><input type="submit" value="Calcular a Média" align="center"/></p>
         </form>
	</div>
</body>
</html>