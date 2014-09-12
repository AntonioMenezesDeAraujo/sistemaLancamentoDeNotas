package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AlunoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AlunoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.DisciplinaDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Disciplina;

public class SevicoCadastroAluno implements Servico {

	@Override
	public String executaLogica(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String nome;
		String matricula;
		String disciplina;

		nome = request.getParameter("nome");
		matricula = request.getParameter("mat");
		disciplina = request.getParameter("disciplina");
		Disciplina disc = null;
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setMatricula(matricula);

		if (!(disciplina == null)) {
			if (!disciplina.equals("")) {
				disc = new DisciplinaDaoImpl().pesquisaDisciplinaPelaDescricao(
						disciplina).get(0);
			}
		}
		AlunoDao dao = new AlunoDaoImpl();
		dao.salvarAluno(aluno, disc);
		return "../aluno/cadAluno.jsp";

			

	}

}
