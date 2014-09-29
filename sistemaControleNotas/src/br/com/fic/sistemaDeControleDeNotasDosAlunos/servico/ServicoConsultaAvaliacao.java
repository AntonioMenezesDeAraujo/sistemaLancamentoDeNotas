package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AvaliacaoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AvaliacaoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao;

public class ServicoConsultaAvaliacao implements Servico{

	@Override
	public void executaLogica(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String criterio = req.getParameter("buscar");
		
		AvaliacaoDao dao = new AvaliacaoDaoImpl();
		
		List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
		List<Avaliacao> avaliacoesCod = dao.pesquisarAvaliacaoPorCodigo(criterio);
		if(avaliacoesCod != null && !avaliacoesCod.isEmpty()){
			avaliacoes.addAll(avaliacoesCod);
		}
		List<Avaliacao> avaliacoesDesc = dao.pesquisarAvaliacaoPorDescricao(criterio);
		if(avaliacoesDesc != null && !avaliacoesDesc.isEmpty()){
			avaliacoes.addAll(avaliacoesDesc);
		}
		
		req.setAttribute( "lista", avaliacoes);  
	}

	@Override
	public String getNomePaginaSucesso() {
		return "conAvaliacao.jsp";
	}

	@Override
	public String getNomePaginaErro() {
		return "conAvaliacao.jsp";
	}

}
