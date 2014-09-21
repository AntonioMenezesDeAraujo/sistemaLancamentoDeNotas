package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AvaliacaoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AvaliacaoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao;

public class ServicoSalvarAvaliacao implements Servico {

	@Override
	public String executaLogica(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		String descricao = req.getParameter("descricao");
		String codigo = req.getParameter("codigo");
		String peso = req.getParameter("peso");

		Avaliacao avaliacao = new Avaliacao();
		avaliacao.setDescricao(descricao);
		avaliacao.setCodigo(codigo);
		avaliacao.setPeso(peso);
		
		AvaliacaoDao dao = new AvaliacaoDaoImpl();
		dao.cadastroDeAvaliacao(avaliacao);
		return "cadAvaliacao.jsp";
	}

}
