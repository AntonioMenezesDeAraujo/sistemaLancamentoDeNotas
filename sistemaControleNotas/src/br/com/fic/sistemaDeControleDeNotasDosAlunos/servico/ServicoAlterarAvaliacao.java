package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AvaliacaoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AvaliacaoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao;

public class ServicoAlterarAvaliacao implements Servico{

	@Override
	public String executaLogica(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		AvaliacaoDao dao = new AvaliacaoDaoImpl();
		
		String codigoOriginal = req.getParameter("codigo");
		String descricaoOriginal = req.getParameter("descricao");
		String pesoOriginal = req.getParameter("peso");
		
		String codigoAlterada = req.getParameter("codigoAlterado");
		String descricaoAlterado = req.getParameter("descricaoAlterado");
		String pesoAlterado = req.getParameter("pesoAlterado");
		
		List<Avaliacao> avaliacoes = dao.pesquisarAvaliacao();
		Avaliacao  avaliacao = null;
		
		for(Avaliacao av:avaliacoes){
			if(av.getCodigo().equals(codigoOriginal)){
				avaliacao = av;
				break;
			}
		}
		
		if(avaliacao != null){
			avaliacao.setCodigo(codigoAlterada);
			avaliacao.setDescricao(descricaoAlterado);
			avaliacao.setPeso(pesoAlterado);
		}
		
		dao.alterarDadosDaAvaliacao(avaliacao);
		
		return "altAvaliacao.jsp";
	}

}
