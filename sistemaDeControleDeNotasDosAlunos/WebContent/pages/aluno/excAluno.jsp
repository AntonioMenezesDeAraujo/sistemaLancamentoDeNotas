<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Excluir Alunos</title>
<link rel="stylesheet" type="text/css" href="../../css/estilo.css" />
</head>
<body>
<div class="geral">
	   <jsp:include page="../layout/cabecalho.html" />
     	<form action="" aling="center">
			<label>Nome:</label>
			<input type="text" size="20" name="nome" /><br></br>
			<label>Matr�cula</label>
			<input type="text" size="20" name="mat" /> <br></br>
			<input  type="submit" value="Excluir"></input>
			<input  type="reset" value="Limpar"></input>
			<a href="index.htm"><input  type="submit" value="Cancelar"></input></a>
		</form>
	</div>
</body>
</html>