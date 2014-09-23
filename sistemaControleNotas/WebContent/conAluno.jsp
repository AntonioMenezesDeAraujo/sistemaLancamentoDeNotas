<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Consultar Aluno</title>
<link rel="stylesheet" type="text/css" href="<c:url value="estilo.css" />" />
</head>
<body>
	<div class="geral">
		<jsp:include page="cabecalho.html" />
		<form class="formulario" action="AlunoServlet?parametro=ServicoConsultaAluno" method="post">
			<p>
				<label>Digite nome ou matrícula do aluno:</label> 
				<input type="text"	size="50" name="buscar" /> <input type="submit" value="Pesquisar"/>
			</p>
         </form>
         
			<table>
				<tr>
					<td></td>
					<td>Nome</td>
					<td>Matrícula</td>
				</tr>
				<c:forEach var="aluno" items="${lista}">
					<tr>
						<td>
							<a href="<c:url value="altAluno.jsp?matricula=${aluno.matricula}&nome=${aluno.nome}" />"><img src="imagens/editar.png" title="Alterar" /></a>
							<a href="<c:url value="excAluno.jsp?matricula=${aluno.matricula}&nome=${aluno.nome}" />"><img src="imagens/excluir.png" title="Excluir"/></a> 
						</td>
						<td>${aluno.nome}</td>
						<td>${aluno.matricula}</td>
					</tr>
				</c:forEach>
			</table>

	</div>
</body>
</html>