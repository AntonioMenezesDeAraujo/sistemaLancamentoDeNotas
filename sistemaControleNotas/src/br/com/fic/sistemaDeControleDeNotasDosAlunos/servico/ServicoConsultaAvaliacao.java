package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AvaliacaoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.DisciplinaDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AvaliacaoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.DisciplinaDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Disciplina;

public class ServicoConsultaAvaliacao implements Servico{

	@Override
	public String executaLogica(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		DisciplinaDao daoDisc = new DisciplinaDaoImpl();
		
		String TxDisciplina = req.getParameter("busca");
		Disciplina disciplina = daoDisc.pesquisaDisciplinaPelaDescricao(TxDisciplina).get(0);
		
		AvaliacaoDao dao = new AvaliacaoDaoImpl();
		req.setAttribute( "lista", dao.pesquisarAvaliacaoPorDisciplina(disciplina));  

		return "conAvaliacao.jsp";	
	}

}
