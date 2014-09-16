package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AlunoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AlunoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;

public class ServicoExcluirAluno implements Servico{

	@Override
	public String executaLogica(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
			
		String matricula = req.getParameter("mat");
		
		AlunoDao dao = new AlunoDaoImpl();
		Aluno aluno =  dao.pesquisarAlunoPorMaricula(matricula).get(0);
		dao.excluirAluno(matricula, aluno.getAlunosDisciplina().get(0).getDisciplina());

		return "excAluno.jsp";
	}

}
