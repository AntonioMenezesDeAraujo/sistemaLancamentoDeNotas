package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AlunoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AlunoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;

public class ServicoCadastroAluno implements Servico {

	@Override
	public String executaLogica(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String nome;
		String matricula;

		nome = request.getParameter("nome");
		matricula = request.getParameter("mat");
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setMatricula(matricula);

		AlunoDao dao = new AlunoDaoImpl();
		dao.salvarAluno(aluno);
		return "cadAluno.jsp";
	}

}
