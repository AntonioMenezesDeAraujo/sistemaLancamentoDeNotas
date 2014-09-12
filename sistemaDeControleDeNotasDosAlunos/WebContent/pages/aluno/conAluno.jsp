<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Consulta Aluno</title>
<link rel="stylesheet" type="text/css" href="<c:url value="../css/estilo.css" />" />
<link rel="stylesheet" type="text/css" href="<c:url value="/pages/css/estilo.css" />" />
</head>
<body>
	<div class="geral">
		<jsp:include page="../layout/cabecalho.html" />
		<form action="../../salvarAluno?parametro=ServicoConsultaAluno"
			method="post">
			<p>
				<label>Digite nome ou matricula do aluno</label> 
				<input type="text"	size="50" name="buscar" /> <input type="submit" value="Pesquisar"/>
			</p>
         </form>
         
			<table>
				<tr>
					<td>Nome</td>
					<td>Matr�cula</td>
					<td>A��es</td>
				</tr>
				<c:forEach var="aluno" items="${lista}">
					<tr>
						<td>${aluno.nome}</td>
						<td>${aluno.matricula}</td>
						<td>
							<a href="<c:url value="/pages/aluno/altAluno.jsp?matricula=${aluno.matricula}&nome=${aluno.nome}" />"/>Alterar</a>
							<a href="<c:url value="/pages/aluno/excAluno.jsp?matricula=${aluno.matricula}&nome=${aluno.nome}" />"/>Excluir</a> 
						</td>
					</tr>
				</c:forEach>
			</table>
			

		
	</div>
</body>
</html>