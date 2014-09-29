package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AvaliacaoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AvaliacaoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Avaliacao;

public class ServicoExcluirAvaliacao implements Servico{

	@Override
	public void executaLogica(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String codigo = req.getParameter("codigo");
		
		AvaliacaoDao dao = new AvaliacaoDaoImpl();

		List<Avaliacao> avaliacoes = dao.pesquisarAvaliacao();
		
		Avaliacao avaliacao = new Avaliacao();
		
		for(Avaliacao av : avaliacoes){
			if(av.getCodigo().equals(codigo)){
				avaliacao = av;
				break;
			}
		}
		
		dao.excluirAvaliacao(avaliacao);

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
