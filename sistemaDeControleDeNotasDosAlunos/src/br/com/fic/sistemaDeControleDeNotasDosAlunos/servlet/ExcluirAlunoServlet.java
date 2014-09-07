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
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Aluno;
import br.com.fic.sistemaDeControleDeNotasDosAlunos.entidades.Disciplina;

/**
 * Servlet implementation class ExcluirAlunoServlet
 */
@WebServlet("/ExcluirAlunoServlet")
public class ExcluirAlunoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ExcluirAlunoServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		Disciplina disciplina = new Disciplina();
		nome = request.getParameter("nome");
		matricula = request.getParameter("mat");
		
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setMatricula(matricula);
		disciplina.setDescricao(request.getParameter("disciplina"));
		
		AlunoDao dao = new AlunoDaoImpl();
		dao.excluirAluno(aluno.getMatricula(), disciplina);
	}
}
