<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Alterar Aluno</title>
<link rel="stylesheet" type="text/css" href="<c:url value="estilo.css" />"/>
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
     	<form class="formulario" action="AvaliacaoServlet?parametro=ServicoAlterarAvaliacao" aling="center" method="post">
			
			<p>
				<label>Codigo:</label>
				<input type="text" size="20" name="codigoAlterado" value="<%= codigo%>"/>
			</p>
			
			<p>
				<label>Descrição:</label>
				<input type="text" size="20" name="descricaoAlterado" value="<%=  descricao%>" />
			</p>
			
			<p>
				<label>Peso:</label>
				<input type="text" size="20" name="pesoAlterado" value="<%=  peso%>" />
			</p>
			<p>
				<input  type="submit" value="Alterar"></input>
				<input  type="reset" value="Limpar"></input>
				<a href="index.htm"><input  type="submit" value="Cancelar"></input></a>
			</p>
			
			<input  type="hidden" name="codigo" value="<%= codigo%>"/>
			<input  type="hidden" name="descricao" value="<%= descricao%>"/>
			<input  type="hidden" name="peso" value="<%= peso%>"/>
		</form>
	</div>
</body>
</html>