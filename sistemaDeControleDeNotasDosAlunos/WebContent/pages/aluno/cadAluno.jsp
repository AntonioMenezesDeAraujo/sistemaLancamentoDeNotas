<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<script type="text/javascript" language="javascript">
	function validaAluno() {
		alert("oi");
	}
</script>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Cadastro de alunos</title>
<link rel="stylesheet" type="text/css" href="../css/estilo.css" />
<script language="javascript" src="../../js/styleCombobox.js"></script>


</head>
		
<body>
<jsp:useBean id="dao" class="br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.DisciplinaDaoImpl"/>
	
	<div id="id" class="geral">
		<jsp:include page="../layout/cabecalho.html" />
		<form action="../../salvarAluno?parametro=SevicoCadastroAluno" name="formulario" method="post">

			<label>Disciplina:</label>
			<select size="1" name="disciplina" class="styleCombobox">
				<option selected value="Selecione">Selecione uma diciplina</option>
					<c:forEach var="disciplina" items="${dao.todasDisciplinas}">
						<option> ${disciplina.descricao}</option>
					</c:forEach>
			</select> 
			<br></br>
			
			<label>Nome:</label> <input type="text" size="20" name="nome" /><br></br>
			<label>Matrícula</label> <input type="text" size="20" name="mat" />
			
			<br></br> <input type="submit" value="Cadastro" /> 
					  <input type="reset" value="Limpar" />
					   <a href="index.htm"> <input	type="submit" value="Cancelar" /></a>
		</form>
	</div>
	<input type="button" onclick="validaAluno()" value="click" />
</body>
</html>

