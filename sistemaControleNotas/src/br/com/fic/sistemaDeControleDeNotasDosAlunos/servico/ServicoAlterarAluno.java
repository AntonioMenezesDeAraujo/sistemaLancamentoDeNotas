package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AlunoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AlunoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;

public class ServicoAlterarAluno implements Servico{

	@Override
	public String executaLogica(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		AlunoDao dao = new AlunoDaoImpl();
		
		String matriculaOriginal = req.getParameter("matriculaOriginal");
		String nomeOriginal = req.getParameter("nomeOriginal");
		
		String matriculaAlterada = req.getParameter("matriculaAlterado");
		String nomeAlterado = req.getParameter("nomeAlterado");
		
		Aluno aluno = dao.pesquisarAlunoPorMaricula(matriculaOriginal).get(0);
		
		aluno.setNome(nomeAlterado);
		aluno.setMatricula(matriculaAlterada);
		
		dao.alterarDadosDoAluno(aluno);

		return "altAluno.jsp";
	}

}
