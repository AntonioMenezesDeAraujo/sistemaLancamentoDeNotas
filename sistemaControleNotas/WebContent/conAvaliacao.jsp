<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Consulta Avaliação</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="estilo.css" />" />
<link rel="stylesheet" type="text/css"
	href="<c:url value="estilo.css" />" />
</head>
<body>
	<form class="formulario"
		action="AvaliacaoServlet?parametro=ServicoConsultaAvaliacao" method="post">
		<div class="geral">
			<jsp:include page="cabecalho.html" />
			<p>
				<label>Digite o código ou descricao da avaliacao: </label> 
				<input type="text"	size="50" name="buscar" /> 
				<input type="submit" value="Pesquisar"/>
				
			</p>
			<table>
				<tr>
					<td></td>
					<td>Código</td>
					<td>Descrição</td>
					<td>Peso</td>
				</tr>
				<c:forEach var="avaliacao" items="${lista}">
					<tr>
						<td>
							<a href="<c:url value="altAvaliacao.jsp?codigo=${avaliacao.codigo}&descricao=${avaliacao.descricao}&peso=${avaliacao.peso}" />"><img src="imagens/editar.png" title="Alterar" /></a>
							<a href="<c:url value="excAvaliacao.jsp?codigo=${avaliacao.codigo}&descricao=${avaliacao.descricao}&peso=${avaliacao.peso}" />"><img src="imagens/excluir.png" title="Excluir"/></a>
						</td>
						<td>${avaliacao.descricao}</td>
						<td>${avaliacao.codigo}</td>
						<td>${avaliacao.peso}</td>
					</tr>
				</c:forEach>
			</table>

		</div>
	</form>
</body>
</html>