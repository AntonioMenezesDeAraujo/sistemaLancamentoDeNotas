package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AvaliacaoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AvaliacaoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao;

public class ServicoCadastroAvaliacao implements Servico{

	@Override
	public void executaLogica(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		String codigo;
		String descricao;
		
		codigo = req.getParameter("codigo");
		descricao = req.getParameter("descricao");
		
		Avaliacao avaliacao = new Avaliacao();
		
		avaliacao.setCodigo(codigo);
		avaliacao.setDescricao(descricao);
		
		AvaliacaoDao daoAv = new AvaliacaoDaoImpl();
		daoAv.cadastroDeAvaliacao(avaliacao);
		
	}

	@Override
	public String getNomePagina() {
		return "cadAvaliacao.jsp";
	}

}
