package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AvaliacaoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AvaliacaoDaoImpl;

public class ServicoConsultaAvaliacao implements Servico{

	@Override
	public String executaLogica(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
				
		AvaliacaoDao dao = new AvaliacaoDaoImpl();
		req.setAttribute( "lista", dao.pesquisarAvaliacao());  

		return "conAvaliacao.jsp";	
	}

}
