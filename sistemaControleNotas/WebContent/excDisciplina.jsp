<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Excluir Alunos</title>
<link rel="stylesheet" type="text/css" href="<c:url value="estilo.css" />"/>
<link rel="stylesheet" type="text/css" href="<c:url value="estilo.css" />"/>

</head>
<body>
<div class="geral">
	   <jsp:include page="cabecalho.html" />
	   <%
	   String codigo = request.getParameter("codigo");
	   String descricao = request.getParameter("descricao");
	   %>
     	<form action="DisciplinaServlet?parametro=ServicoExcluirDisciplina" aling="center" method="post">
			<label>Codigo: </label>
			<input type="text" size="20" name="descricao" value = "<%= codigo%>" /><br></br>
			<label>Descri��o: </label>
			<input type="text" size="20" name="codigo" value = "<%= descricao %>" /> <br></br>
			<input  type="submit" value="Excluir"></input>
			<input  type="reset" value="Limpar"></input>
			<a href="index.htm"><input  type="submit" value="Cancelar"></input></a>
		</form>
	</div>
</body>
</html>