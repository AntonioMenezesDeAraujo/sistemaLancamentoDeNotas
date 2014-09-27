package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AvaliacaoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AvaliacaoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao;

public class ServicoCadastroAvaliacao implements Servico {

	@Override
	public void executaLogica(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String descricao = req.getParameter("descricao");
		String codigo = req.getParameter("codigo");

		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setDescricao(descricao);
		avaliacao.setCodigo(codigo);
		
		AvaliacaoDao dao = new AvaliacaoDaoImpl();
		dao.cadastroDeAvaliacao(avaliacao);
	}

	@Override
	public String getNomePagina() {
		return "cadAvaliacao.jsp";
	}

}
