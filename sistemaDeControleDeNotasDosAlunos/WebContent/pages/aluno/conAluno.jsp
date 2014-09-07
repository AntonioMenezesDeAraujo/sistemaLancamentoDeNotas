!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Consulta Aluno</title>
<link rel="stylesheet" type="text/css" href="../../css/estilo.css" />
</head>	
<body>
<body>
	<div class="geral">
	   <jsp:include page="../layout/cabecalho.html" />
     	<form action="" >
			<p><label>Digite nome ou matricula do aluno</label>
			<input type="text" size="50" name="buscar" />
			<input type="submit" value="Pesquisar"/></p>
			
			<table border="0" cellpadding="20" cellspacing="">
			<tr> <td> Nome  </td> <td> Matrícula  </td> <td> Ações  </td> </tr>
			
			</table>
			
			
			
			
			
			
<!-- 			<fieldset style="width: 300px; height: 100px" > -->
<!-- 			<legend>Resultado da Busca</legend> -->
<!-- 			<label> Nome </label> -->
<!-- 			<input type="text" size="20" name="buscaNome" /><br/> -->
<!-- 			<label>Matrícula</label> -->
<!-- 			<input type="text" size="20" name="buscaMatricula" /><p/> -->
<!-- 			<input  type="submit" value="Alterar"></input> -->
<!-- 			<input  type="submit" value="Excluir"></input> -->
<!-- 			<a href="index.htm"><input  type="submit" value="Cancelar"></input></a> -->
<!-- 			</fieldset>	 -->
</form>
</body>
</html>