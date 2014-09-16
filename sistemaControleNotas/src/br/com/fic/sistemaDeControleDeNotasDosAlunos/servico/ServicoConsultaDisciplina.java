package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.DisciplinaDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.DisciplinaDaoImpl;

public class ServicoConsultaDisciplina implements Servico{

	@Override
	public String executaLogica(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		String criterio = req.getParameter("buscar");
		
		DisciplinaDao dao = new DisciplinaDaoImpl();
		req.setAttribute( "lista", dao.pesquisaDisciplinaPelaDescricao(criterio));  
		return "conDisciplina.jsp";
	}

}
