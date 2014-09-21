<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Consulta Aluno</title>
<link rel="stylesheet" type="text/css" href="<c:url value="estilo.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="estilo.css" />" />
</head>
<body>
	<div class="geral">
		<jsp:include page="cabecalho.html" />         
			<table>
				<tr>
					<td>Código</td>
					<td>Descrição</td>
					<td>Ações</td>
				</tr>
				<c:forEach var="avaliacao" items="${lista}">
					<tr>
						<td>${avaliacao.descricao}</td>
						<td>${avaliacao.codigo}</td>
<%-- 						<td>${avaliacao.peso}</td> --%>
						<td>
							<a href="<c:url value="altDisciplina.jsp?codigo=${disciplina.codigo}&descricao=${disciplina.descricao}" />">Alterar</a>
							<a href="<c:url value="excDisciplina.jsp?codigo=${disciplina.codigo}&descricao=${disciplina.descricao}" />">Excluir</a> 
						</td>
					</tr>
				</c:forEach>
			</table>
			
	</div>
</body>
</html>