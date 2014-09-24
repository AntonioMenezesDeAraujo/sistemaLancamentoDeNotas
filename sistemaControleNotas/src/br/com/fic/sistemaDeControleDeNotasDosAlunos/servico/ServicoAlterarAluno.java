package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AlunoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AlunoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;

public class ServicoAlterarAluno implements Servico{

	@Override
	public void executaLogica(HttpServletRequest req, HttpServletResponse res) throws Exception {
		AlunoDao dao = new AlunoDaoImpl();
		
		String matriculaOriginal = req.getParameter("matriculaOriginal");
		String nomeAlterado = req.getParameter("nomeAlterado");
		
		Aluno aluno = dao.pesquisarAlunoPorMatricula(matriculaOriginal).get(0);
		
		aluno.setNome(nomeAlterado);
		
		dao.alterarDadosDoAluno(aluno);

	}

	@Override
	public String getNomePagina() {
		return "conAluno.jsp";
	}

}
