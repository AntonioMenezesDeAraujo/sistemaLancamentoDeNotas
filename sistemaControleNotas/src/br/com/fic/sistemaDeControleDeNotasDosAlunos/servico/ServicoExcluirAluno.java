package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AlunoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AlunoDaoImpl;

public class ServicoExcluirAluno implements Servico{

	@Override
	public void executaLogica(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
			
		String matricula = req.getParameter("mat");
		
		AlunoDao dao = new AlunoDaoImpl();
		dao.excluirAluno(matricula);

	}

	@Override
	public String getNomePagina() {
		return "excAluno.jsp";
	}

}
