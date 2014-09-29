<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Excluir Avaliação</title>
<link rel="stylesheet" type="text/css" href="<c:url value="estilo.css" />"/>

</head>
<body>
<div class="geral">
	   <jsp:include page="cabecalho.html" />
	   
	   <%
		   String codigo = request.getParameter("codigo");
		   String descricao = request.getParameter("descricao");
		   String peso = request.getParameter("peso");
	   %>
	   
     	<form class="formulario" action="AvaliacaoServlet?parametro=ServicoExcluirAvaliacao" method="post">
			<p>Deseja realmente excluir o registro abaixo?</p>
			<p>
				<label>Código:</label>
				<input type="text" size="20" name="codigo" value = "<%= codigo%>" />
			</p>
		
			<p>
				<label>Descricão:</label>
				<input type="text" size="20" name="descricao" value = "<%= descricao %>" /> 
			</p>
			
			<p>
				<label>Peso:</label>
				<input type="text" size="20" name="peso" value = "<%= peso %>" /> 
			</p>
			
			<p>
				<input  type="submit" value="Excluir"></input>
				<a href="conAvaliacao.jsp" class="button">Voltar</a>
			</p>
			
		</form>
	</div>
</body>
</html>