<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Cadastrar Avaliação</title>
<link rel="stylesheet" type="text/css" href="<c:url value="estilo.css" />"/>
</head>
	
<body>	
	<div id="id" class="geral">
		<jsp:include page="cabecalho.html" />
		
		<%
	 		String erro = request.getParameter("erro");
			String message = request.getParameter("message");
			String codigo = request.getParameter("codigo");
			String descricao = request.getParameter("descricao");
	 	%>
		
		<form class="formulario" action="AvaliacaoServlet?parametro=ServicoCadastroAvaliacao" name="formulario" method="post">

			<%
				if(message != null && !message.isEmpty()){
					out.print("<div class=\"sucess\">" + message + "</div>");
				}
				if(erro != null && !erro.isEmpty()){
					out.print("<div class=\"error\">" + erro + "</div>");
				}
				
				codigo = codigo != null ? codigo : "";
				descricao = descricao != null ? descricao : "";
	 		%>
	 		
			<p><label>Código:</label> <input type="text" size="20" name="codigo" value="<%= codigo %>"/></p>
			
			<p><label>Descrição:</label> <input type="text" size="20" name="descricao" value="<%= descricao %>"/></p>
			
			<p> 
				<input type="submit" value="Cadastrar" /> 
				<a href="index.jsp" class="button">Voltar</a>
			</p>
		</form>
	</div>
</body>
</html>

