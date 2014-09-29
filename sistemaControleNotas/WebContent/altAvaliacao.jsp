<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Alterar Avalia��o</title>
<link rel="stylesheet" type="text/css" href="<c:url value="estilo.css" />"/>

</head>
<body>
<div class="geral">
	 <jsp:include page="cabecalho.html" />
	 <%
	   String erro = request.getParameter("erro");
	   String codigo = request.getParameter("cod");
	   String descricao = request.getParameter("desc");
	 %>
     	<form class="formulario" action="AvaliacaoServlet?parametro=ServicoAlterarAvaliacao" method="post">
			<%
				if(erro != null && !erro.isEmpty()){
					out.print("<div class=\"error\">" + erro + "</div>");
				}
	 		%>
			<p>
				<label>Descri��o:</label>
				<input type="text" size="20" name="descricaoAlterado" value="<%=  descricao%>" />
			</p>
			
			<p>
				<input  type="submit" value="Alterar"></input>
				<a href="conAvaliacao.jsp" class="button">Voltar</a>
			</p>
			
			<input  type="hidden" name="codigo" value="<%= codigo%>"/>
			<input  type="hidden" name="descricao" value="<%= descricao%>"/>
		</form>
	</div>
</body>
</html>