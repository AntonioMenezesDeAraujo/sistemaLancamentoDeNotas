<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Cadastrar avalia��o</title>
<link rel="stylesheet" type="text/css" href="<c:url value="estilo.css" />"/>
<link rel="stylesheet" type="text/css" href="<c:url value="estilo.css" />"/>
</head>
	
<body>	
	<div id="id" class="geral">
		<jsp:include page="cabecalho.html" />
		
		<form action="AlunoServlet?parametro=ServicoCadastroAvaliacao" name="formulario" method="post">

			<label>C�digo:</label> <input type="text" size="20" name="codigo" /><br></br>
			
			<label>Descri��o:</label> <input type="text" size="20" name="descricao" /><br></br>
			
			<label>Peso</label> <input type="text" size="20" name="mat" />
			
			<br></br> <input type="submit" value="Cadastro" /> 
					  <input type="reset" value="Limpar" />
					   <a href="index.htm"> <input	type="submit" value="Cancelar" /></a>
		</form>
	</div>
	<input type="button" onclick="validaAluno()" value="click" />
</body>
</html>

