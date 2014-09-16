package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.DisciplinaDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.DisciplinaDaoImpl;

public class ServicoExcluirDisciplina implements Servico{

	@Override
	public String executaLogica(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
        String codigo = req.getParameter("codigo");
		
		DisciplinaDao dao = new DisciplinaDaoImpl();
		dao.excluirDisciplina(codigo);

		return "excDisciplina.jsp";
	}

}
