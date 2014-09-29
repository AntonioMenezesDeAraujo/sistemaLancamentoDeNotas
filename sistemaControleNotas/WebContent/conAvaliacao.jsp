<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AvaliacaoDaoImpl"%>
<%@page import="br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AvaliacaoDao"%>
<%@page import="br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao"%>
<%@page import="java.util.List"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Consultar Avaliação</title>
<link rel="stylesheet" type="text/css" href="<c:url value="estilo.css" />" />
</head>
<body>
	<div class="geral">
		<jsp:include page="cabecalho.html" />
		<form class="formulario" action="AlunoServlet?parametro=ServicoConsultaAvaliacao" method="post">
			<p>
				<label>Digite o código ou descrição da avaliação:</label> 
				<input type="text"	size="50" name="buscar" /> 
				<input type="submit" value="Pesquisar"/>
			</p>
         </form>
         
			<table>
				<tr>
					<td></td>
					<td>Código</td>
					<td>Descrição</td>

				</tr>
				<%
				String parametro = request.getParameter("buscar");
				if(parametro != null){
				AvaliacaoDao dao = new AvaliacaoDaoImpl();
				List<Avaliacao> avaliacoes = dao.pesquisarAvaliacao();
				for(Avaliacao av: avaliacoes){
					if(av.getCodigo().equals(parametro) || av.getDescricao().toUpperCase().contains(parametro.toUpperCase())){
				%>
					<tr>
						<td>
						<%
							String codigo = av.getCodigo();
							String descricao = av.getDescricao();
// 							request.setAttribute("cod", codigo);
// 							request.setAttribute("desc", descricao);
						%>
							<a href="altAvaliacao.jsp?cod=<%=codigo %>&desc=<%=descricao%>"><img src="imagens/editar.png" title="Alterar" /></a>
							<a href="excAvaliacao.jsp?cod=<%=codigo %>&desc=<%=descricao %>"><img src="imagens/excluir.png" title="Excluir"/></a>
						</td>
						<td><%=av.getCodigo() %></td>
						<td><%=av.getDescricao() %></td>
					</tr>
					<%} }}%>
			</table>
	</div>
</body>
</html>
