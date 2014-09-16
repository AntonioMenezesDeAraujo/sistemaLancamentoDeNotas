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
		<form action="DisciplinaServlet?parametro=ServicoConsultaDisciplina"  method="post">
			<p>
				<label>Digite a descricao da disciplina</label> 
				<input type="text"	size="50" name="buscar" /> <input type="submit" value="Pesquisar"/>
			</p>
         </form>
         
			<table>
				<tr>
					<td>Descricao</td>
					<td>Codigo</td>
				</tr>
				<c:forEach var="disciplina" items="${lista}">
					<tr>
						<td>${disciplina.descricao}</td>
						<td>${disciplina.codigo}</td>
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