package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.DisciplinaDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.DisciplinaDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Disciplina;

public class ServicoAlterarDisciplina implements Servico{

	@Override
	public String executaLogica(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		DisciplinaDao dao = new DisciplinaDaoImpl();
		
		String descricaoOriginal = req.getParameter("descricaoOriginal");
		String codigoOriginal = req.getParameter("codigoOriginal");
		
		String descricaoAlterada = req.getParameter("descricaoAlterado");
		String codigoAlterado = req.getParameter("codigoAlterado");
		
		Disciplina disciplina = dao.pesquisaDisciplinaPeloCodigo(codigoOriginal).get(0);
		
		disciplina.setDescricao(descricaoAlterada);
		disciplina.setCodigo(codigoAlterado);
		
		dao.alteraDisciplina(disciplina);

		return "altDisciplina.jsp";
	}

}
