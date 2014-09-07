package br.com.fic.sistemaDeControleDeNotasDosAlunos.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.fic.sistemaDeControleDeNotasDosAlunos.dao.AlunoDao;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.AlunoDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.daoImpl.DisciplinaDaoImpl;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Disciplina;

@WebServlet("/SalvarAlunoServlet")
public class SalvarAlunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SalvarAlunoServlet() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		service(request, response);
	}
	
	@Override
	public void service(ServletRequest request, ServletResponse response)
			throws ServletException, IOException {
		super.service(request, response);

		String nome;
		String matricula;
		String disciplinas;
		
		nome = request.getParameter("nome");
		matricula = request.getParameter("mat");
		disciplinas = request.getParameter("disciplina");
		
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setMatricula(matricula);
		
		Disciplina disc = new DisciplinaDaoImpl().pesquisaDisciplinaPelaDescricao(disciplinas).get(0);
		AlunoDao dao = new AlunoDaoImpl();
		dao.salvarAluno(aluno, disc);
		
	}

}
