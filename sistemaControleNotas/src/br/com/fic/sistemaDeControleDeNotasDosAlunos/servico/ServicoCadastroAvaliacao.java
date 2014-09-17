package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AvaliacaoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.DisciplinaDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AvaliacaoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.DisciplinaDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao;

public class ServicoCadastroAvaliacao implements Servico{

	@Override
	public String executaLogica(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		String disciplina;
		String descricao;
		String codigo;
		
		codigo = req.getParameter("codigo");
		disciplina = req.getParameter("disciplina");
		descricao = req.getParameter("descricao");
		
		DisciplinaDao dao = new DisciplinaDaoImpl();
		Avaliacao avaliacao = new Avaliacao();
		
		avaliacao.setCodigo(codigo);
		avaliacao.setDisciplina(dao.pesquisaDisciplinaPelaDescricao(disciplina).get(0));
		avaliacao.setDescricao(descricao);
		
		AvaliacaoDao daoAv = new AvaliacaoDaoImpl();
		daoAv.cadastroDeAvaliacaoNaDisciplina(avaliacao);
		
		return "cadAvaliacao.jsp";
	}

}
