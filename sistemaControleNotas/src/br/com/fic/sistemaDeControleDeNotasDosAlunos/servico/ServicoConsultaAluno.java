package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AlunoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AlunoDaoImpl;

public class ServicoConsultaAluno implements Servico {

	@Override
	public String executaLogica(HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		
		String criterio = req.getParameter("buscar");
		
		AlunoDao dao = new AlunoDaoImpl();
		req.setAttribute( "lista", dao.pesquisarAlunoPorNome(criterio));  
//		req.getRequestDispatcher("/pages/aluno/conAluno.jsp").forward( req, res); 
//		res.setContentType ("text/html;charset=utf-8");
		return "conAluno.jsp";
	}

}
