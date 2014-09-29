package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AlunoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AvaliacaoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AlunoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AvaliacaoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;

public class ServicoPesquisarAluno implements Servico {

	@Override
	public void executaLogica(HttpServletRequest req, HttpServletResponse res) throws Exception {
		try {
			AlunoDao dao = new AlunoDaoImpl();
			AvaliacaoDao daoAv = new AvaliacaoDaoImpl();
			String matricula = req.getParameter("mat");

			Aluno aluno = dao.pesquisarAluno(matricula).get(0);
			
			req.setAttribute("alunoSelecionado", aluno);
			
			req.setAttribute("avaliacoesSelecionada",daoAv.pesquisarAvaliacao());
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public String getNomePaginaSucesso() {
		return "lancarNota.jsp";
	}

	@Override
	public String getNomePaginaErro() {
		return "lancNotas.jsp";
	}

}
