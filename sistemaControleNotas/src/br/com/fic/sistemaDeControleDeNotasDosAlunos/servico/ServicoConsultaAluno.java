package br.com.fic.sistemaDeControleDeNotasDosAlunos.servico;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AlunoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AlunoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;

public class ServicoConsultaAluno implements Servico {

	@Override
	public void executaLogica(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		String criterio = req.getParameter("buscar");
		
		AlunoDao dao = new AlunoDaoImpl();
		List<Aluno> alunos = new ArrayList<Aluno>();
		List<Aluno> alunosNome = dao.pesquisarAlunoPorNome(criterio);
		if(alunosNome != null && !alunosNome.isEmpty()){
			alunos.addAll(alunosNome);
		}
		List<Aluno> alunosMatricula = dao.pesquisarAlunoPorMatricula(criterio);
		if(alunosMatricula != null && !alunosMatricula.isEmpty()){
			alunos.addAll(alunosMatricula);
		}
		
		req.setAttribute("lista", alunos);  

	}

	@Override
	public String getNomePagina() {
		return "conAluno.jsp";
	}

}
