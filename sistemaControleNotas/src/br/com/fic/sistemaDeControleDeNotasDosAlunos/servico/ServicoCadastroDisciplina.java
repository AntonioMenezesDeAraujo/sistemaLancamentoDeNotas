package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.DisciplinaDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.DisciplinaDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Disciplina;

public class ServicoCadastroDisciplina implements Servico {

	@Override
	public String executaLogica(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		String descricao;
		String codigo;

		descricao = req.getParameter("decricao");
		codigo = req.getParameter("codigo");
		
		Disciplina disc = new Disciplina();
		
		disc.setDescricao(descricao);
		disc.setCodigo(codigo);

		DisciplinaDao dao = new DisciplinaDaoImpl();
		dao.salvarDisciplina(disc);
		
		return "cadDisciplina.jsp";
	}

}
